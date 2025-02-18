package com.example.progetto_ispw.dao;

import com.example.progetto_ispw.model.Questionario;

import java.io.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Classe che gestisce le operazioni di lettura e scrittura su file CSV relativi ai questionari e alle risposte.
 * La classe è progettata per interagire con due file: uno che contiene i questionari e uno che memorizza le risposte.
 */
public class QuestionarioFileSystemDAO {

    private static QuestionarioFileSystemDAO instance;
    private static String connectionPath = "src/main/resources/com/example/progetto_ispw/questionario_202502131850.csv";
    private static String connectionPath2 = "src/main/resources/com/example/progetto_ispw/collabs_202502131936.csv";
    static Connection connection;

    protected QuestionarioFileSystemDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Recupera i questionari da un file CSV e li converte in oggetti Questionario.
     *
     * @return un ArrayList contenente i questionari letti dal file.
     * @throws RuntimeException in caso di errori durante la lettura del file.
     */
    protected ArrayList<Questionario> getQuestionarios(){
        ArrayList<Questionario> questionarios = new ArrayList<>();
        String codiceQuest;
        String domanda;
        String risposta;
        String argomento;
        String riga;
        String [] elementi_riga;

        try {
            FileReader fr = new FileReader(connectionPath);
            if (fr == null) {
                throw new IllegalArgumentException("file non trovato: " + connectionPath);
            }
            BufferedReader br = new BufferedReader(fr);
            while ((riga = br.readLine()) != null) {
                elementi_riga = riga.split(",");

                codiceQuest = elementi_riga[0];
                domanda = elementi_riga[1];
                risposta = elementi_riga[2];
                argomento = elementi_riga[3];

                Questionario questionario = new Questionario(
                        codiceQuest,
                        argomento,
                        domanda,
                        new ArrayList<>(Arrays.asList(risposta.split("\\|")))
                );
                questionarios.add(questionario);
            }
            return questionarios;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Registra una risposta a un questionario in un file CSV.
     *
     * @param codiceQuest il codice identificativo del questionario.
     * @param risposta la risposta fornita dall'utente.
     * @param email l'email dell'utente che ha risposto.
     * @return true se la risposta è stata salvata correttamente, false altrimenti.
     */
    protected boolean votedQuest(String codiceQuest, String risposta, String email) {
        String line = codiceQuest + "," + risposta + "," + email + "," + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        List<String> lines = new ArrayList<>();

        try {
            FileWriter fw = new FileWriter(connectionPath2, true);
            if (fw == null) {
                throw new IllegalArgumentException("file non trovato: " + connectionPath2);
            }
            BufferedWriter bw = new BufferedWriter(fw);
            for (String l : lines) {
                bw.write(l);
                bw.newLine();
            }
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
