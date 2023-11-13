package com.form.app.springbootform.services;

// Metodo List
import java.util.List;

// Modelo de la entity
import com.form.app.springbootform.model.Pais;

public interface PaisService {

    public List<Pais> listAll();

    public Pais findById(Integer id);
}
