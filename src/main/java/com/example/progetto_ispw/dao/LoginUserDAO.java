package com.example.progetto_ispw.dao;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

public class LoginUserDAO {
    Connection connection;

    public LoginUserDAO (Connection connection) {
        this.connection = connection;
    }

    protected boolean loginUser(String email, String pass){
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
        System.out.println("login riuscito");
        return true;
    }
}

