package com.example.progetto_ispw.controller;



import com.example.progetto_ispw.dao.LoginUserDAO;
import com.example.progetto_ispw.view.LoginUserView;

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
        LoginUserView loginView = new LoginUserView();
        ArrayList<String> inputRes = loginView.logininput();
        String email = inputRes.get(0);
        String password = inputRes.get(1);

        this.attributi = loginDAO.login(email, password);
    }

    public ArrayList<String> getAttributi(){
        return this.attributi;
    }
}
