package com.example.progetto_ispw.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

public class InternalLoginDAO {
    Connection connection;

    public InternalLoginDAO (Connection connection) {
        this.connection = connection;
    }

    public ArrayList<String> internalLogin(String token){
        String nome;
        String cognome;
        String email;
        String cellulare;
        ArrayList<String> attributi = new ArrayList<>();

        CallableStatement cs = null;
        try {
            cs = connection.prepareCall("{call login(?,?,?,?,?)}");
            cs.setString(1, token);
            cs.registerOutParameter(2, Types.VARCHAR);
            cs.registerOutParameter(3, Types.VARCHAR);
            cs.registerOutParameter(4, Types.VARCHAR);
            cs.registerOutParameter(5, Types.VARCHAR);
            cs.executeQuery();
            nome = cs.getString(2);
            cognome = cs.getString(3);
            email = cs.getString(4);
            cellulare = cs.getString(5);

            attributi.add(nome);
            attributi.add(cognome);
            attributi.add(email);
            attributi.add(cellulare);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return attributi;
    }
}