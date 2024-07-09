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

    public boolean loginUser(String user, String pass){
        String username;
        String nome;
        String email;
        String cellulare;
        String dataDiNascita;
        String bio;
        ArrayList<String> attributi = new ArrayList<>();

        CallableStatement cs = null;
        try {
            cs = connection.prepareCall("{call login(?,?,?,?,?,?,?,?)}");
            cs.setString(1, user);
            cs.setString(2, pass);
            cs.registerOutParameter(3, Types.VARCHAR);
            cs.registerOutParameter(4, Types.VARCHAR);
            cs.registerOutParameter(5, Types.VARCHAR);
            cs.registerOutParameter(6, Types.VARCHAR);
            cs.registerOutParameter(7, Types.VARCHAR);
            cs.executeQuery();
            username = cs.getString(3);
            nome = cs.getString(4);
            email = cs.getString(5);
            cellulare = cs.getString(6);
            dataDiNascita = cs.getString(7);
            bio = cs.getString(8);
            attributi.add(username);
            attributi.add(nome);
            attributi.add(email);
            attributi.add(cellulare);
            attributi.add(dataDiNascita);
            attributi.add(bio);
            attributi.add(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}

