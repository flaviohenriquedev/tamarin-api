package api.tamarin.gerenciamentoSistema.gestaoLocalidade.estado.service;

import api.tamarin._root.comum.service.DtoMapper;
import api.tamarin._root.comum.service.impl.DefaultServiceImpl;
import api.tamarin._root.comum.service.impl.DtoMapperImpl;
import api.tamarin.gerenciamentoSistema.gestaoLocalidade.estado.dto.EstadoDTO;
import api.tamarin.gerenciamentoSistema.gestaoLocalidade.estado.model.Estado;
import api.tamarin.gerenciamentoSistema.gestaoLocalidade.estado.repository.EstadoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EstadoService extends DefaultServiceImpl<Estado, EstadoDTO> {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    protected JpaRepository<Estado, UUID> getRepository() {
        return estadoRepository;
    }

    @Override
    protected DtoMapper<Estado, EstadoDTO> getMapper() {
        return new DtoMapperImpl<>(modelMapper, Estado.class, EstadoDTO.class);
    }
}
