package com.example.progetto_ispw.controller;


import com.example.progetto_ispw.model.Questionario;
import com.example.progetto_ispw.model.Statistiche;
import com.example.progetto_ispw.model.User;
import javafx.util.Pair;

import java.util.ArrayList;


public class MasterController {

    private static MasterController instance;
    QuestionarioController qc = new QuestionarioController();



    private MasterController() {}

    public static MasterController getInstance() {
        if(instance==null) {
            instance = new MasterController();
        }
        return instance;
    }

    public boolean login(String email, String password) {
        LoginUserController luc = new LoginUserController();
        luc.login();
        return true;
    }


    public ArrayList<Questionario> getQuestSearched() {
        qc.getQuestSearched();
        return null;
    }

    public Questionario getQuestionario() {
        qc.getQuestionario();
        return qc.getQuestionario();
    }

    public void votedQuest(String risposta) {
        qc.votedQuest(risposta);
    }

    public void goToQuest(Questionario q) {
        qc.goToQuest(q);
    }

    public void nextQuest() {
       qc.nextQuest();
    }

    public void createQuest() {
        qc.createQuest();
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
        ilc.InternalLogin();
        return true;
    }
}
