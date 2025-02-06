package com.example.progetto_ispw.controller;

import com.example.progetto_ispw.dao.MasterDAO;
import com.example.progetto_ispw.model.User;
import com.example.progetto_ispw.dao.UserDAO;
import com.example.progetto_ispw.view.UserView;

import java.sql.Connection;
import java.util.ArrayList;

public class UserController {

    private static UserController instance;
    User user;

    private UserController() {
    }

    public static UserController getInstance() {
        if(instance==null) {
            instance = new UserController();
        }
        return instance;
    }


    public boolean registrazioneUser(String username,String nome, String email, String password, String cellulare,  String dataDiNascita, String nazionalita, String sesso,  String bio) {
        boolean result =  MasterDAO.getInstance().registrazioneUser(username, nome, email, password, cellulare, dataDiNascita, nazionalita, sesso, bio);
        if (result){
            user.setEmail(email);

            return result;
        }
        return false;
    }

    public User getUser() {
        return user;
    }







}
