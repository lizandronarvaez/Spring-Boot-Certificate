package com.form.app.springbootform.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.form.app.springbootform.services.PaisService;

@Component
public class PaisPropertyEditor extends PropertyEditorSupport {

    // Inyectar el servicio pais
    @Autowired
    private PaisService paisService;

    @Override
    public void setAsText(String idString) throws IllegalArgumentException {

        try {

            Integer id = Integer.parseInt(idString);
            this.setValue(paisService.findById(id));

        } catch (Exception e) {
            setValue(null);

        }
    }

}
