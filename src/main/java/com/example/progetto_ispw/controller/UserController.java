package com.example.progetto_ispw.controller;

import com.example.progetto_ispw.model.User;
import com.example.progetto_ispw.dao.UserDAO;
import com.example.progetto_ispw.view.UserView;

import java.sql.Connection;
import java.util.ArrayList;

public class UserController implements Controller {

    User user;
    UserView uview;
    UserDAO udao;

    @Override
    public void start(Connection connection, ArrayList<String> attributi) {

        this.user = new User(
                attributi.get(1),
                attributi.get(2),
                attributi.get(3),
                attributi.get(4),
                attributi.get(5),
                attributi.get(6),
                attributi.get(7)
        );
        this.uview = new UserView();
        this.udao = new UserDAO(connection);

        int choice = -1;
    }

    public User getCurrentUser() {
        //TODO
        createUser();
        return user;
    }

    public void createUser(){
        String username = "pippo"; //Il nome utente univoco scelto dall'utente.
        String nome = "pippo ciao";
        String email = "pippo@gmail.com";
        String password = "pass";
        String cellulare = "333";
        String dataDiNascita = "2020-03-03";
        String bio = "ciao";
        this.user = new User(username, nome, email, password, cellulare, dataDiNascita, bio);
    }

}
