package com.form.app.springbootform.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.form.app.springbootform.model.Role;

@Service
public class RoleServiceImpl implements RoleService {

    private List<Role> list;

    public RoleServiceImpl() {
        this.list = new ArrayList<>();
        this.list.add(new Role(1, "Administrador", "admin"));
        this.list.add(new Role(2, "Usuario", "user"));
    }

    @Override
    public List<Role> findAll() {

        return list;
    }

    @Override
    public Role findById(Integer id) {
        Role rol = null;
        for (Role role : list) {
            if (role.getId() == id) {
                rol = role;
                break;
            }
        }
        return rol;
    }
}
