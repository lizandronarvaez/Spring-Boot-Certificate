package com.form.app.springbootform.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.form.app.springbootform.model.Pais;

@Service
public class PaisServiceImpl implements PaisService {

    private List<Pais> list;

    public PaisServiceImpl() {
        this.list = Arrays.asList(

                new Pais(1, "ES", "España"),
                new Pais(2, "MEX", "Mexico"),
                new Pais(3, "CHI", "Chile"),
                new Pais(4, "ECU", "Ecuador"));
    }

    @Override
    public List<Pais> listAll() {
        return list;
    }

    @Override
    public Pais findById(Integer id) {

        Pais resultado = null;

        for (Pais pais : list) {
            if (pais.getId() == id) {
                resultado = pais;
                break;
            }
        }

        return resultado;
    }

}
