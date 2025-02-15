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
            File file = new File(connectionPath);
            if (!file.exists()) {
                throw new FileNotFoundException("File non trovato: " + connectionPath);
            }

            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();
            if (line == null || !line.contains("=")) {
                throw new IllegalArgumentException("Formato non valido nel file di configurazione");
            }
            stringConnessione = line.split("=")[1];

            line = br.readLine();
            if (line == null || !line.contains("=")) {
                throw new IllegalArgumentException("Formato non valido: manca il parametro username");
            }
            username = line.split("=")[1];

            line = br.readLine();
            if (line == null || !line.contains("=")) {
                throw new IllegalArgumentException("Formato non valido: manca il parametro password");
            }
            password = line.split("=")[1];

            br.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Errore: impossibile trovare il file di configurazione " + connectionPath, e);
        } catch (IOException e) {
            throw new RuntimeException("Errore durante la lettura del file di configurazione", e);
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
