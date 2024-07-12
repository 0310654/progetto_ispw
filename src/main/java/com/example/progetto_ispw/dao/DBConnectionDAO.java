package com.example.progetto_ispw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionDAO {

    private static DBConnectionDAO instance;
    static Connection connection;

    //TODO creare la base di dati mysql e quindi poi mettere i dati della connesione
    private DBConnectionDAO() {
        String stringConnessione = "jdbc:mysql://localhost:3306/progetto_ispw";
        String username = "root";
        String password = "password";
        try {
            connection = DriverManager.getConnection(stringConnessione, username, password);
        } catch(SQLException e) {
            e.printStackTrace();
            connection = null;
        }
    }

    protected static DBConnectionDAO getInstance() {
        if(instance==null) {
            instance = new DBConnectionDAO();
        }
        return instance;
    }

    protected Connection getConnection() {
        return connection;
    }
}
