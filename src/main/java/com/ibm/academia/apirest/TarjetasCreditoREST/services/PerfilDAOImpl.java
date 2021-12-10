package com.ibm.academia.apirest.TarjetasCreditoREST.services;

import com.ibm.academia.apirest.TarjetasCreditoREST.entities.Perfil;
import com.ibm.academia.apirest.TarjetasCreditoREST.repositories.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PerfilDAOImpl extends GenericoDAOImpl<Perfil, PerfilRepository> implements PerfilDAO{
    @Autowired
    public PerfilDAOImpl(PerfilRepository repository)
    {
        super(repository);
    }
}
