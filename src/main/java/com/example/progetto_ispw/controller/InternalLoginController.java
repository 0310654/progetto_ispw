package com.example.progetto_ispw.controller;

import com.example.progetto_ispw.dao.InternalLoginDAO;

import java.sql.Connection;

public class InternalLoginController {

    private Connection connection;


    public InternalLoginController() {
        this.connection = connection;
        internalLogin();
    }

    public InternalLoginDAO internalLogin() {
        InternalLoginDAO internalLoginDAO = new InternalLoginDAO(connection);
        return internalLoginDAO;
    }
}
