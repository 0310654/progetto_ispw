package com.example.progetto_ispw.dao;
import com.example.progetto_ispw.controller.LoginUserController;
import com.example.progetto_ispw.model.User;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe di test che verifica le funzionalità delle operazioni correlate nel database.
 * La classe contiene metodi per testare le funzionalità di registrazione, login, gestione dei questionari e cancellazione dei dati
 * per evitare dati suprflui conseguenti a numerosi casi di test.
 */
public class TesterDAO {

    Connection connection;

    public boolean connectionTest(){
        try{
            this.connection =DBConnectionDAO.getInstance().getConnection();
        } catch(Error e){
            return false;
        }
        return true;
    }

    /**
     * Esegue un test per la registrazione di un utente nel database.
     *
     * @return true se la registrazione è avvenuta con successo, false altrimenti.
     */
    public boolean registrazioneTest() {

        String username = "Luigi1";
        String nome = "luigi";
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
            return false;
        }
        return true;
    }

    /**
     * Esegue un test di login con email e password specificate.
     *
     * @param mail_corretta indica se l'email e la password sono corrette.
     * @return true se il login è avvenuto con successo, false altrimenti.
     */
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
            return false;
        }
    }

    /**
     * Testa il recupero dei questionari dal database.
     *
     * @return true se i questionari sono stati recuperati correttamente, false altrimenti.
     */
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

    /**
     * Testa la registrazione di una risposta a un questionario nel database.
     *
     * @return true se la risposta è stata registrata correttamente, false altrimenti.
     */
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

    /**
     * Cancella un utente di test dal database utilizzando la stored procedure.
     *
     * @param email l'email dell'utente da cancellare.
     * @param password la password dell'utente da cancellare.
     * @return true se l'utente è stato cancellato correttamente, false altrimenti.
     */
    public boolean deleteUserTestDAO(String email,String password  ) {

        String call = "{call delete_test_user(?,?)}" ;

        try (CallableStatement callableStatement = this.connection.prepareCall(call)) {
            callableStatement.setString(1, email);
            callableStatement.setString(2, password);
            callableStatement.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    /**
     * Cancella una votazione di un utente di test dal database utilizzando la stored procedure.
     *
     * @param email l'email dell'utente di test di cui cancellare la votazione.
     * @return true se la votazione è stata cancellata correttamente, false altrimenti.
     */
    public boolean deleteVoteTestDAO(String email) {
        String call = "{call delete_vote_test(?)}" ;

        try (CallableStatement callableStatement = this.connection.prepareCall(call)) {
            callableStatement.setString(1, email);
            callableStatement.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    /**
     * per il test sono stati utilizzati due utenti di prova differenti nel
     * caso di Controller e di DAO, ma la funzione non cambia
     */
    public boolean deleteUserTestController(String email, String password) {

        String call = "{call delete_test_user(?,?)}" ;

        try (CallableStatement callableStatement = this.connection.prepareCall(call)) {
            callableStatement.setString(1, email);
            callableStatement.setString(2, password);
            callableStatement.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean deleteVoteTestController(String email) {

        String call = "{call delete_vote_test(?)}" ;

        try (CallableStatement callableStatement = this.connection.prepareCall(call)) {
            callableStatement.setString(1, email);
            callableStatement.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

}
