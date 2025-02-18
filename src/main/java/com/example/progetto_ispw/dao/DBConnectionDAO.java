package com.example.progetto_ispw.dao;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe che gestisce la connessione al database utilizzando un file di configurazione.
 * Il pattern Singleton è utilizzato per garantire che ci sia una sola istanza di DBConnectionDAO
 * durante l'esecuzione dell'applicazione.
 */
public class DBConnectionDAO {

    private static DBConnectionDAO instance;
    private static String connectionPath = "src/main/resources/com/example/progetto_ispw/dbConfiguration.txt";
    static Connection connection;

    /**
     * Costruttore privato che legge il file di configurazione per ottenere i parametri di connessione al database
     * e stabilisce una connessione utilizzando DriverManager.
     *
     * @throws RuntimeException se il file di configurazione non viene trovato o se la connessione al database fallisce.
     */
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

        // Tentativo di connessione al database
        try {
            connection = DriverManager.getConnection(stringConnessione, username, password);
        } catch(SQLException e) {
            e.printStackTrace();
            connection = null;
        }
    }

    /**
     * Metodo per ottenere l'istanza unica di DBConnectionDAO (Pattern Singleton).
     *
     * @return l'istanza unica di DBConnectionDAO.
     */
    protected static DBConnectionDAO getInstance() {
        if(instance==null) {
            instance = new DBConnectionDAO();
        }
        return instance;
    }

    /**
     * Metodo che restituisce la connessione al database.
     *
     * @return l'oggetto Connection che rappresenta la connessione al database.
     */
    protected Connection getConnection() {
        return connection;
    }
}
