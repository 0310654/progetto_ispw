package com.example.progetto_ispw.controller;


import com.example.progetto_ispw.model.Questionario;
import com.example.progetto_ispw.model.User;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;


public class MasterController {

    private static MasterController instance;
    User user;

    private MasterController() {}

    public static MasterController getInstance() {
        if(instance==null) {
            instance = new MasterController();
        }
        return instance;
    }

    public boolean login(String email, String password) {
        return LoginUserController.getInstance().login(email, password);
    }

    public boolean registrazioneUser(ArrayList<String> result) {
        String username = result.get(0);
        String nome  = result.get(1);
        String email = result.get(2);
        String password = result.get(3);
        String cellulare = result.get(4);
        String dataDiNascita = result.get(5);
        String nazionalita = result.get(6);
        String sesso = result.get(7);
        String bio = result.get(8);
        return UserController.getInstance().registrazioneUser(username, nome,  email,  password,  cellulare, dataDiNascita, nazionalita, sesso, bio);
    }


    //restituisce il questionario a cui voglio votare
    public Questionario getQuestionario() {
        return QuestionarioController.getInstance().getQuestionario();
    }

    //ho votato: salva la mia risposta
    public boolean votedQuest(String risposta) {
        String email = getCurrentUser().getEmail();
        return QuestionarioController.getInstance().votedQuest(risposta, email);
    }


    //TODO restituisce una lista di questionari in base alla parola cercata nella barra nella homepage
    public ArrayList<Questionario> getQuestSearched() {
        QuestionarioController.getInstance().getQuestSearched();
        return null;
    }

    public void goToQuest(Questionario q) {
        QuestionarioController.getInstance().goToQuest(q);
    }

    public void nextQuest() {
        QuestionarioController.getInstance().nextQuest();
    }

    /*public void createQuest() {
        QuestionarioController.getInstance().createQuest();
    }*/

    public User getCurrentUser() {
        return LoginUserController.getInstance().getUser();
    }

    private void createUser(){
        UserController uc = UserController.getInstance();
        //uc.createUser();
    }

    /*TODO capire a cosa serve questa funzione
    public void recuperaCollab() {
        CollabsController cc = new CollabsController();
        cc.recuperaCollab();
    }*/

    public List<AbstractMap.SimpleEntry<String, String>> getCollabs() {
        CollabsController cc = new CollabsController();
        String email = getCurrentUser().getEmail();
        return cc.getCollabs(email);
    }

   /* public boolean internalLogin(String token) {
        InternalLoginController ilc = new InternalLoginController();
        ilc.internalLogin(token);
        return ilc.internalLogin(token);
    }*/

}
