package com.example.progetto_ispw.controller;

import com.example.progetto_ispw.dao.MasterDAO;
import com.example.progetto_ispw.model.User;


/**
 * Il pattern Singleton è utilizzato per garantire che ci sia una sola istanza
 * di UserController durante l'esecuzione dell'applicazione.
 */
public class UserController {

    private static UserController instance;
    User user;

    /**
     * Costruttore privato per prevenire la creazione di più istanze della classe.
     */
    private UserController() {
    }

    /**
     * Metodo per ottenere l'istanza unica di UserController (Pattern Singleton).
     *
     * @return l'istanza unica di UserController.
     */
    public static UserController getInstance() {
        if(instance==null) {
            instance = new UserController();
        }
        return instance;
    }

    public boolean registrazioneUser(String username,String nome, String email, String password, String cellulare,  String dataDiNascita, String nazionalita, String sesso,  String bio) {
        boolean result =  MasterDAO.getInstance().registrazioneUser(username, nome, email, password, cellulare, dataDiNascita, nazionalita, sesso, bio);
        if (result){
            user = new User(username, nome, email, password, cellulare, dataDiNascita, nazionalita, sesso, bio);
            return result;
        }
        return false;
    }
}
