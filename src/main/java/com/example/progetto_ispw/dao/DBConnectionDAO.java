package com.example.progetto_ispw.dao;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionDAO {

    private static DBConnectionDAO instance;
    private static String connectionPath = "src/main/resources/com/example/progetto_ispw/dbConfiguration.txt";
    static Connection connection;

    private DBConnectionDAO() {
        String stringConnessione;
        String username;
        String password;

        try {
            FileReader fr = new FileReader(connectionPath);
            if (fr == null) {
                throw new IllegalArgumentException("file non trovato: " + connectionPath);
            }
            BufferedReader br = new BufferedReader(fr);
            stringConnessione = br.readLine().split("=")[1];
            username = br.readLine().split("=")[1];
            password = br.readLine().split("=")[1];
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

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
