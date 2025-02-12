package com.example.progetto_ispw.controller;
import com.example.progetto_ispw.dao.MasterDAO;
import com.example.progetto_ispw.model.User;
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

    public boolean login(String email, String password) {
        String EMAIL_REGEX = "^[^@]+@[^@]+\\.[^@]+$";
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        if (email != null && pattern.matcher(email).matches() && password != null) {
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
            return false;
        } else {
            System.err.println("Invalid email or password");
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

