package com.example.progetto_ispw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionDAO {

    Connection connection;

    //TODO creare la base di dati mysql e quindi poi mettere i dati della connesione
    public DBConnectionDAO() {
        String stringConnessione = " ";
        String username = " ";
        String password = " ";
        try {
            this.connection = DriverManager.getConnection(stringConnessione, username, password);
        } catch(SQLException e) {
            e.printStackTrace();
            this.connection = null;
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
