package com.example.progetto_ispw.controller;



import com.example.progetto_ispw.dao.DBConnectionDAO;
import com.example.progetto_ispw.dao.MasterDAO;

import java.sql.Connection;
import java.util.ArrayList;

public class LoginUserController {

    private ArrayList<String> attributi;
    private Connection connection;


    public LoginUserController(Connection connection) {
        this.connection = this.connection;
        login();
    }


    public ArrayList<String> getAttributi(){
        return this.attributi;
    }

    public boolean login(String email, String password) {
        if (isValidEmail(email) && isValidPassword(password)) {
            Connection connection = MasterController.getConnection();
            MasterDAO.getInstance().setConnection(connection);
            return MasterDAO.getInstance().loginUser(email, password);
        }
        return false;
    }

    public static boolean isValidEmail(String email) {
        if (email == null || email.length() < 5) { // email should be at least of the form a@b.c
            return false;
        }
        int atIndex = -1;
        int dotIndex = -1;
        int atCount = 0;

        for (int i = 0; i < email.length(); i++) {
            char ch = email.charAt(i);

            if (ch == '@') {
                atCount++;
                atIndex = i;
            } else if (ch == '.') {
                dotIndex = i;
            }
        }

        return atCount == 1 && atIndex > 0 && dotIndex > atIndex + 1 && dotIndex < email.length() - 1;
    }

    public static boolean isValidPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (Character.isUpperCase(ch)) {
                hasUpper = true;
            } else if (Character.isLowerCase(ch)) {
                hasLower = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else if ("@#$%^&+=!".contains(String.valueOf(ch))) {
                hasSpecial = true;
            }

            // Early exit if all conditions are met
            if (hasUpper && hasLower && hasDigit && hasSpecial) {
                return true;
            }
        }
        return hasUpper && hasLower && hasDigit && hasSpecial;
    }
}

