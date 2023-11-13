package com.form.app.springbootform.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.form.app.springbootform.services.RoleService;

@Component
public class RolePropertyEditor extends PropertyEditorSupport {

    @Autowired
    private RoleService roleService;

    @Override
    public void setAsText(String idString) throws IllegalArgumentException {

        try {
            Integer id = Integer.parseInt(idString);
            this.setValue(roleService.findById(id));
        } catch (NumberFormatException e) {
            setValue(null);
        }
    }

}
