package com.example.progetto_ispw.controller;

import com.example.progetto_ispw.dao.InternalLoginDAO;
import com.example.progetto_ispw.dao.MasterDAO;

import java.sql.Connection;

public class InternalLoginController {

    private Connection connection;


    public InternalLoginController() {
    }

    public boolean internalLogin(String token) {
        return MasterDAO.getInstance().loginInternalUser(token);
    }
}
