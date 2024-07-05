package com.example.progetto_ispw.controller;



import com.example.progetto_ispw.dao.LoginUserDAO;

import java.sql.Connection;
import java.util.ArrayList;

public class LoginUserController {

    private ArrayList<String> attributi;
    private Connection connection;

    public LoginUserController(Connection connection){
        this.connection = connection;
        start();
    }

    //@Override
    public void start() {
        LoginUserDAO loginDAO = new LoginUserDAO(connection);

    }

    public ArrayList<String> getAttributi(){
        return this.attributi;
    }
}
