package com.br.tamarin.root.service.impl;

import com.br.tamarin.root.model.EntidadePadrao;
import com.br.tamarin.root.service.CRUDService;

import java.io.Serializable;
import java.util.List;

public abstract class CRUDServiceImpl<E extends EntidadePadrao, ID extends Serializable> implements CRUDService<E, ID> {
}
