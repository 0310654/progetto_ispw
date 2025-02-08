package com.example.progetto_ispw.dao;

import com.example.progetto_ispw.model.Questionario;

import java.sql.Connection;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

public class MasterDAO {

    private static MasterDAO instance;
    private Connection connection;

    private MasterDAO() {
        this.connection = DBConnectionDAO.getInstance().getConnection();
    }

    public static MasterDAO getInstance() {
        if(instance==null) {
            instance = new MasterDAO();
        }
        return instance;
    }

    public ArrayList<String> loginUser(String email, String password) {
        LoginUserDAO lud = new LoginUserDAO(connection);
        return lud.loginUser(email, password);
    }

    public ArrayList<Questionario> getQuestionarios() {
        QuestionarioDAO qd = new QuestionarioDAO(connection);
        return qd.getQuestionarios();
    }

    public boolean votedQuest(String codiceQuest, String risposta, String email) {
        QuestionarioDAO qd = new QuestionarioDAO(connection);
        return qd.votedQuest(codiceQuest, risposta, email);
    }

    public boolean  registrazioneUser(String username, String nome, String email, String password, String cellulare, String dataDiNascita, String nazionalita, String sesso, String bio) {
        UserDAO ud = new UserDAO(connection);
        return ud.registrazioneUser(username,nome,email, password, cellulare,dataDiNascita,nazionalita,sesso,bio);
    }


    public List<AbstractMap.SimpleEntry<String, String>> getCollabs(String email) {
        CollabsDAO cd = new CollabsDAO(connection);
        return cd.getCollabs(email);
    }

}

