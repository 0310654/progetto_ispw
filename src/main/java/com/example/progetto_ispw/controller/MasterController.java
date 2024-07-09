package com.example.progetto_ispw.controller;


import com.example.progetto_ispw.dao.InternalLoginDAO;
import com.example.progetto_ispw.dao.LoginUserDAO;
import com.example.progetto_ispw.model.Questionario;
import com.example.progetto_ispw.model.User;
import javafx.util.Pair;

import java.sql.Connection;
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

    public static Connection getConnection() {

    }

    public LoginUserDAO login(String email, String password) {
        LoginUserController luc = new LoginUserController(dbConnectionDAO.getConnection());
        luc.login();
        return luc.login();
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

    public InternalLoginDAO internalLogin(String token) {
        InternalLoginController ilc = new InternalLoginController();
        ilc.internalLogin();
        return ilc.internalLogin();
    }
}
