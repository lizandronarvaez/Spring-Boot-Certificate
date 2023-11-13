package com.form.app.springbootform.editors;

import java.beans.PropertyEditorSupport;

public class DataUpperCase extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {

        setValue((text.trim().toLowerCase()));
    }

}
