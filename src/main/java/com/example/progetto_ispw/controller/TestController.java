package com.example.progetto_ispw.controller;

import com.example.progetto_ispw.dao.LoginUserDAO;
import com.example.progetto_ispw.model.Questionario;
import com.example.progetto_ispw.model.User;
import com.example.progetto_ispw.view.MasterView;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class TestController {

    public boolean test_registrazioneUser(){
        String username = "Carlo1";
        String nome = "carlo";
        System.out.println("nome e username user: " + username + " " + nome);
        String email = "carlo@email.com";
        String password = "password";
        String cellulare = "3334455777\n";
        String datanascita = "2001-01-01\n";
        String nazionalita = "IT";
        String sesso = "M";
        String bio = "nuovo utente";
        try {
            UserController.getInstance().registrazioneUser(username,nome,email,password,cellulare,datanascita,nazionalita,sesso,bio);
        } catch ( Error e ) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean loginTest(boolean mail_corretta){
        String email;
        String password;
        if(mail_corretta) {
            email = "carlo@email.com";
            password = "password";
        } else {
            email = "carlo@email.com";
            password = "password_sbagliata";
        }
        try {
            return LoginUserController.getInstance().login(email,password);
        } catch ( Error e ) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean getQuestionarioTest(){
        try {
            User u = new User("Luigi1",
                    "Luigi",
                    "luigi@email.com",
                    "password",
                    "",
                    "",
                    "",
                    "",
                    "");
            LoginUserController.getInstance().setUser(u);
            Questionario q  = QuestionarioController.getInstance().getQuestionario();
            if (q == null) {
                return false;
            }
        } catch ( Error e ) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean votedQuestTest(){
        String risposta = "Cani";
        String email = "carlo@email.com";
        try {
            QuestionarioController.getInstance().votedQuest(risposta, email);
        } catch ( Error e ) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }


    public int cercaQuestTest(String input){
        try {
            QuestionarioController.getInstance().setupQuestionari();
            QuestionarioController.getInstance().cercaQuest(input);
            Questionario q = QuestionarioController.getInstance().getQuestionario();

            Integer minDistance = null;
            int distanza;
            String domanda = q.getDomanda();
            for (String s : domanda.split(" ")) {
                distanza = QuestionarioController.levCalculate(input.toLowerCase(), s.toLowerCase());
                if (distanza <= 2 && minDistance == null) {
                    minDistance = distanza;
                }
                else if (distanza <= 2 && distanza < minDistance) {
                    minDistance = distanza;
                }
            }
            for (String s : q.getPossibiliRisposte()) {
                distanza = QuestionarioController.levCalculate(input.toLowerCase(), s.toLowerCase());
                if (distanza <= 2 && minDistance == null) {
                    minDistance = distanza;
                }
                else if (distanza <= 2 && distanza < minDistance) {
                    minDistance = distanza;
                }
            }
            String argomento = q.getArgomento();
            for (String s : argomento.split(" ")) {
                distanza = QuestionarioController.levCalculate(input.toLowerCase(), s.toLowerCase());
                if (distanza <= 2 && minDistance == null) {
                    minDistance = distanza;
                }
                else if (distanza <= 2 && distanza < minDistance) {
                    minDistance = distanza;
                }
            }
            if(minDistance != null) {
                return minDistance;
            } else {
                return -1;
            }
        } catch ( Error e ) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

}
