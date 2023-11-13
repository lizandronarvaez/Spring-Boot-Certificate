package com.form.app.springbootform.services;

import java.util.List;

import com.form.app.springbootform.model.Role;

public interface RoleService {

    public List<Role> findAll();

    public Role findById(Integer id);
}
