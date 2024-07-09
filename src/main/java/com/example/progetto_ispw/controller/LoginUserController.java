package com.example.progetto_ispw.controller;



import com.example.progetto_ispw.dao.LoginUserDAO;

import java.sql.Connection;
import java.util.ArrayList;

public class LoginUserController {

    private ArrayList<String> attributi;
    private Connection connection;


    public LoginUserController() {
        this.connection = connection;
        login();
    }


    public ArrayList<String> getAttributi(){
        return this.attributi;
    }

    public void login() {
        LoginUserDAO loginDAO = new LoginUserDAO(connection);
    }
}
