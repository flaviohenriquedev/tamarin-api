package api.gommo._root.comum.repository.impl;

import api.gommo._root._infra.multitenant.TenantContext;
import api.gommo._root.comum.model.EntidadeTenant;
import api.gommo._root.comum.repository.DefaultRepository;
import api.gommo.gerenciamentoSistema.gestaoEmpresa.empresa.model.Empresa;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.Getter;
import org.hibernate.Session;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.util.List;
import java.util.UUID;

public class DefaultRepositoryImpl<T, ID> extends SimpleJpaRepository<T, ID> implements DefaultRepository<T, ID> {

    private final EntityManager entityManager;

    public UUID getEmpresaId() {
        return TenantContext.getEmpresaId(); // Puxa dinamicamente
    }

    public DefaultRepositoryImpl(JpaEntityInformation<T, ?> entityInformation,
                                 EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    private void garantirFiltroTenant() {
        if (getEmpresaId() == null) return;
        Session session = entityManager.unwrap(Session.class);
        if (session.getEnabledFilter("tenantFilter") == null) {
            session.enableFilter("tenantFilter").setParameter("tenantId", getEmpresaId());
        }
    }

    @Override
    @Transactional
    public <S extends T> S save(S entity) {
        setTenantIfApplicable(entity);
        return super.save(entity);
    }

    @Override
    @Transactional
    public <S extends T> List<S> saveAll(Iterable<S> entities) {
        entities.forEach(this::setTenantIfApplicable);
        return super.saveAll(entities);
    }

    @Override
    public List<T> findAll() {
        garantirFiltroTenant();
        return super.findAll();
    }

    @Override
    public java.util.Optional<T> findById(ID id) {
        garantirFiltroTenant();
        return super.findById(id);
    }

    private void setTenantIfApplicable(Object entity) {
        if (entity instanceof EntidadeTenant entidadeTenant && getEmpresaId() != null) {
            Empresa empresa = new Empresa();
            empresa.setId(getEmpresaId());
            entidadeTenant.setEmpresaTenant(empresa);
        }
    }
}
