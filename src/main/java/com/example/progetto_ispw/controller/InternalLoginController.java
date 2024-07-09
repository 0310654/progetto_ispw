package com.example.progetto_ispw.controller;

import com.example.progetto_ispw.dao.InternalLoginDAO;
import com.example.progetto_ispw.dao.LoginUserDAO;

import java.sql.Connection;
import java.util.ArrayList;

public class InternalLoginController {

    private Connection connection;


    public InternalLoginController() {
        this.connection = connection;
        InternalLogin();
    }

    public void InternalLogin() {
        InternalLoginDAO InternalLoginDAO = new InternalLoginDAO();
    }
}
