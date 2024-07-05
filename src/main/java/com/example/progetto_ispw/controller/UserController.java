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
        while (choice != 0) {
            choice = uview.showMenu();
//TODO scrivere le funzioni dello user
            switch (choice) {
                case 0:
                    System.out.println("Chiusura\n");
                    break;
                case 1:
                    //cambioturni();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
        }
    }
}
