package com.example.progetto_ispw.dao;

import com.example.progetto_ispw.model.Questionario;

import java.io.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestionarioFileSystemDAO {

    private static QuestionarioFileSystemDAO instance;
    private static String connectionPath = "src/main/resources/com/example/progetto_ispw/questionario_202502131850.csv";
    private static String connectionPath2 = "src/main/resources/com/example/progetto_ispw/collabs_202502131936.csv";
    static Connection connection;

    protected QuestionarioFileSystemDAO(Connection connection) {
        this.connection = connection;
    }

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
            System.err.println("Errore nella scrittura del file: " + e.getMessage());
            return false;
        }
        return true;
    }
}
