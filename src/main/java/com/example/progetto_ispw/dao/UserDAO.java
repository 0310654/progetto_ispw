package com.example.progetto_ispw.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class UserDAO {
    Connection connection;
    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean registrazioneUser(
            String username,
            String nome,
            String email,
            String password,
            String cellulare,
            String dataDiNascita,
            String nazionalita,
            String sesso,
            String bio) {

        String call = "{call registrazioneUser(?,?,?,?,?,?,?,?,?)}" ;

        try (CallableStatement callableStatement = this.connection.prepareCall(call)) {
            callableStatement.setString(1, username);
            callableStatement.setString(2, nome);
            callableStatement.setString(3, email);
            callableStatement.setString(4, password);
            callableStatement.setString(5, cellulare);
            callableStatement.setString(6, dataDiNascita);
            callableStatement.setString(7, nazionalita);
            callableStatement.setString(8, sesso);
            callableStatement.setString(9, bio);
            callableStatement.execute();
            System.out.println("Fatto! Registrazione riuscita!");
            return true;
        } catch (SQLException e) {
            System.err.println("Errore durante la registrazione: " + e.getMessage());
            return false;
        }
    }
}


