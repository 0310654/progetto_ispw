package com.example.progetto_ispw.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class UserDAO {
    Connection connection;
    public UserDAO(Connection connection) {
        this.connection = connection;
    }
//TODO inserire funzioni dello user
    /*public boolean cambioruoli(String nuovoRuolo, String inizioPeriodo, String cfImpiegato  ) {

        String call = "{call cambio_ruoli(?, ?, ?)}";

        try (CallableStatement callableStatement = this.connection.prepareCall(call)) {
            callableStatement.setString(1, nuovoRuolo);
            callableStatement.setString(2, inizioPeriodo);
            callableStatement.setString(3, cfImpiegato);
            callableStatement.execute();
            System.out.println("Fatto! Ruolo dell'impiegato cambiato");
            return true;
        } catch (SQLException e) {
            System.err.println("Errore durante il cambio del ruolo: " + e.getMessage());
            return false;
        }
    }*/
}
