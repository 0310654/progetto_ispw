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

        if (email == null || email.trim().isEmpty() && password==null) {
            throw new WrongLoginException("Formato email o password non valido");
        }

        // Controllo che ci sia una sola "@"
        int atIndex = email.indexOf('@');
        if (atIndex == -1 || atIndex != email.lastIndexOf('@')) {
            throw new WrongLoginException("Formato email o password non valido");
        }

        // Separazione in due parti: local-part e dominio
        String localPart = email.substring(0, atIndex);
        String domainPart = email.substring(atIndex + 1);

        // Controllo che entrambe le parti abbiano almeno un carattere
        if (localPart.isEmpty() || domainPart.isEmpty()) {
            throw new WrongLoginException("Formato email o password non valido");
        }

        // Controllo che il dominio abbia almeno un punto e non sia all'inizio o alla fine
        int dotIndex = domainPart.indexOf('.');
        if (dotIndex == -1 || dotIndex == 0 || dotIndex == domainPart.length() - 1) {
            throw new WrongLoginException("Formato email o password non valido");
        }
        return true;
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

