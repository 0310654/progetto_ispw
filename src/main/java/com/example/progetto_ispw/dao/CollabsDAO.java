package com.example.progetto_ispw.dao;

import java.sql.*;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

public class CollabsDAO {

    Connection connection;

    protected CollabsDAO(Connection connection) {
        this.connection = connection;
    }

    public List<AbstractMap.SimpleEntry<String, String>> getCollabs(String email) {

        try {
            //in argomento il sistema mette direttamente la mia email per riconoscere i miei questionari nel DB
            CallableStatement cs = connection.prepareCall("{call getcollabs(?)}");
            cs.setString(1, email);
            ResultSet rs = cs.executeQuery();
            List<AbstractMap.SimpleEntry<String, String>> domandaRisposta = new ArrayList<>();

            while (rs.next()) {
                String domanda = rs.getString("domanda");
                String risposta = rs.getString("risposta");
                System.out.println("Domanda: " + domanda + " | Risposta: " + risposta);
                domandaRisposta.add(new AbstractMap.SimpleEntry<>(domanda, risposta));
            }
            return domandaRisposta;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
