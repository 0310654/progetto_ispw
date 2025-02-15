package com.example.progetto_ispw.controller;
import com.example.progetto_ispw.dao.MasterDAO;
import com.example.progetto_ispw.model.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class LoginUserController {

    private static LoginUserController instance;
    User user;

    private LoginUserController() {
    }

    public static LoginUserController getInstance() {
        if(instance==null) {
            instance = new LoginUserController();
        }
        return instance;
    }

    private boolean controllaEmail(String email, String password) throws WrongLoginException {
        String EMAIL_REGEX = "^[^@]+@[^@]+\\.[^@]+$";
        Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
        String PASSWORD_REGEX = "^[a-zA-Z0-9]{8,}$";
        Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);


        if (email != null && EMAIL_PATTERN.matcher(email).matches() && password != null && PASSWORD_PATTERN.matcher(password).matches()) {
            return EMAIL_PATTERN.matcher(email).matches();
        }
        else {
            throw new WrongLoginException("Formato email o password non valido");
        }
    }

    public boolean login(String email, String password) {
        try {
            controllaEmail(email, password);
            ArrayList<String> attributi = MasterDAO.getInstance().loginUser(email, password);
            if (attributi != null && attributi.get(0) != null) {
                user = new User(attributi.get(0), //username
                        attributi.get(1), //nome
                        email,
                        password,
                        attributi.get(2), //cellulare
                        attributi.get(3), //datadinascita
                        attributi.get(4), //nazionalita
                        attributi.get(5), //sesso
                        attributi.get(6)); //bio
                return true;
            }
        } catch (WrongLoginException e) {
            System.err.println("errore nel login: " + e.getMessage());
        }
        return false;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

