package com.example.progetto_ispw.dao;
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

    public boolean deleteUserTest() {

        String email = "luigi@email.com";
        String password = "password" ;

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
}
