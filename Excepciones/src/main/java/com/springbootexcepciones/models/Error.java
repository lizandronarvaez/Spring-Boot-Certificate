package com.springbootexcepciones.models;

import java.util.Date;

import lombok.Data;

@Data
public class Error {

    private String message;
    private String error;
    private int status;
    private Date date;
}
