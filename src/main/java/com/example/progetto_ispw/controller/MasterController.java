package com.example.progetto_ispw.controller;


import com.example.progetto_ispw.dao.DBConnectionDAO;
import com.example.progetto_ispw.dao.InternalLoginDAO;
import com.example.progetto_ispw.dao.LoginUserDAO;
import com.example.progetto_ispw.model.Questionario;
import com.example.progetto_ispw.model.User;
import javafx.util.Pair;

import java.sql.Connection;
import java.util.ArrayList;


public class MasterController {

    private static MasterController instance;

    private MasterController() {}

    public static MasterController getInstance() {
        if(instance==null) {
            instance = new MasterController();
        }
        return instance;
    }

    public boolean login(String email, String password) {
        LoginUserController luc = new LoginUserController();
        return luc.login(email, password);
    }

    //restituisce una lista di questionari in base alla parola cercata nella barra nella homepage
    public ArrayList<Questionario> getQuestSearched() {
        QuestionarioController.getInstance().getQuestSearched();
        return null;
    }
    //restituisce il questionario a cui voglio votare
    public Questionario getQuestionario() {
        return QuestionarioController.getInstance().getQuestionario();
    }
    //ho votato: salva la mia risposta
    public void votedQuest(String risposta) {
        QuestionarioController.getInstance().votedQuest(risposta);
    }

    public void goToQuest(Questionario q) {
        QuestionarioController.getInstance().goToQuest(q);
    }

    public void nextQuest() {
       QuestionarioController.getInstance().nextQuest();
    }

    public void createQuest() {
        QuestionarioController.getInstance().createQuest();
    }

    public User getCurrentUser() {
        UserController uc = new UserController();
        uc.getCurrentUser();
        return uc.getCurrentUser();
    }

    private void createUser(){
        UserController uc = new UserController();
        uc.createUser();
    }

    // TODO capire a cosa serve questa funzione
    public void recuperaCollab() {
        CollabsController cc = new CollabsController();
        cc.recuperaCollab();
    }

    public ArrayList<Pair> getCollabs() {
        CollabsController cc = new CollabsController();
        cc.recuperaCollab();
        return cc.getCollabs();
    }

    public boolean internalLogin(String token) {
        InternalLoginController ilc = new InternalLoginController();
        ilc.internalLogin(token);
        return ilc.internalLogin(token);
    }
}
