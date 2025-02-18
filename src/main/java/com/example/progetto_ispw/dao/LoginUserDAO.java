package com.example.progetto_ispw.dao;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

public class LoginUserDAO {
    Connection connection;

    /**
     * Costruttore che inizializza la connessione al database.
     *
     * @param connection la connessione al database.
     */
    public LoginUserDAO (Connection connection) {
        this.connection = connection;
    }

    protected ArrayList<String> loginUser(String email, String pass){
        String username;
        String nome;
        String cellulare;
        String dataDiNascita;
        String nazionalita;
        String sesso;
        String bio;
        ArrayList<String> attributi = new ArrayList<>();

        CallableStatement cs = null;
        try {
            cs = connection.prepareCall("{call loginUser(?,?,?,?,?,?,?,?,?)}");
            cs.setString(1, email);
            cs.setString(2, pass);
            cs.registerOutParameter(3, Types.VARCHAR);
            cs.registerOutParameter(4, Types.VARCHAR);
            cs.registerOutParameter(5, Types.VARCHAR);
            cs.registerOutParameter(6, Types.VARCHAR);
            cs.registerOutParameter(7, Types.VARCHAR);
            cs.registerOutParameter(8, Types.VARCHAR);
            cs.registerOutParameter(9, Types.VARCHAR);

            cs.executeQuery();
            username = cs.getString(3);
            nome = cs.getString(4);
            cellulare = cs.getString(5);
            dataDiNascita = cs.getString(6);
            nazionalita = cs.getString(7);
            sesso = cs.getString(8);
            bio = cs.getString(9);

            attributi.add(username);
            attributi.add(nome);
            attributi.add(cellulare);
            attributi.add(dataDiNascita);
            attributi.add(nazionalita);
            attributi.add(sesso);
            attributi.add(bio);
        } catch (SQLException e) {
            System.err.println("errore nel login");
            throw new RuntimeException(e);
        }
        System.out.println("login riuscito:\n" +
                "username: " + username + "\n" +
                "email: " + email + "\n" +
                "nome: " + nome + "\n");
        return attributi;
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

