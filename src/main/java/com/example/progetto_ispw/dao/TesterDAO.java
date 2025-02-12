package com.example.progetto_ispw.dao;
import com.example.progetto_ispw.controller.LoginUserController;
import com.example.progetto_ispw.controller.QuestionarioController;
import com.example.progetto_ispw.model.Questionario;
import com.example.progetto_ispw.model.User;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class TesterDAO {

    Connection connection;

    public boolean connectionTest(){
        try{
            this.connection =DBConnectionDAO.getInstance().getConnection();
        } catch(Error e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean registrazioneTest() {

        String username = "Luigi1";
        String nome = "luigi";
        System.out.println("nome e username user: " + username + " " + nome);
        String email = nome + "@email.com";
        String password = "password";
        String cellulare = "3334455666";
        String datanascita = "2002-01-01";
        String nazionalita = "IT";
        String sesso = "M";
        String bio = "nuovo utente";
        try {
            if(connection == null) {
                connectionTest();
            }
            LoginUserDAO lud = new LoginUserDAO(connection);
            lud.registrazioneUser(username, nome,email,password,cellulare,datanascita,nazionalita,sesso,bio);
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
            email = "luigi@email.com";
            password = "password";
        } else {
            email = "luigi@email.com";
            password = "password_sbagliata";
        }
        try {
            if(connection == null) {
                connectionTest();
            }
            LoginUserDAO lud = new LoginUserDAO(connection);
            ArrayList<String> risultato = lud.loginUser(email, password);
            if (risultato.get(3) == null) {
                return false;
            } else {
                return true;
            }
        } catch ( Error e ) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean getQuestionariosTest(){
        try {
            if(connection == null) {
                connectionTest();
            }
            User u = new User("Luigi1", "Luigi", "luigi@email.com", "", "", "", "", "", "");
            LoginUserController.getInstance().setUser(u);
            QuestionarioDAO qd = new QuestionarioDAO(connection);
            qd.getQuestionarios();
            return !qd.getQuestionarios().isEmpty();
        } catch ( Error e ) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean votedQuestTest(){
        String codiceQuest = "Q001";
        String risposta = "Cani";
        String email = "luigi@email.com";
        try {
            if(connection == null) {
                connectionTest();
            }
            QuestionarioDAO qd = new QuestionarioDAO(connection);
            qd.votedQuest(codiceQuest, risposta, email);
        } catch ( Error e ) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean deleteUserTestDAO(String email,String password  ) {

        String call = "{call delete_test_user(?,?)}" ;

        try (CallableStatement callableStatement = this.connection.prepareCall(call)) {
            callableStatement.setString(1, email);
            callableStatement.setString(2, password);
            callableStatement.execute();
            System.out.println("Fatto! utente di test cancellato!");
            return true;
        } catch (SQLException e) {
            System.err.println("Errore: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteVoteTestDAO(String email) {
        String call = "{call delete_vote_test(?)}" ;

        try (CallableStatement callableStatement = this.connection.prepareCall(call)) {
            callableStatement.setString(1, email);
            callableStatement.execute();
            System.out.println("Fatto! votazione dell'utente di test cancellata!");
            return true;
        } catch (SQLException e) {
            System.err.println("Errore: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteUserTestController(String email, String password) {

        String call = "{call delete_test_user(?,?)}" ;

        try (CallableStatement callableStatement = this.connection.prepareCall(call)) {
            callableStatement.setString(1, email);
            callableStatement.setString(2, password);
            callableStatement.execute();
            System.out.println("Fatto! utente di test cancellato!");
            return true;
        } catch (SQLException e) {
            System.err.println("Errore: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteVoteTestController(String email) {

        String call = "{call delete_vote_test(?)}" ;

        try (CallableStatement callableStatement = this.connection.prepareCall(call)) {
            callableStatement.setString(1, email);
            callableStatement.execute();
            System.out.println("Fatto! votazione dell'utente di test cancellata!");
            return true;
        } catch (SQLException e) {
            System.err.println("Errore: " + e.getMessage());
            return false;
        }
    }

}
