package com.example.progetto_ispw.dao;

import com.example.progetto_ispw.controller.MasterController;
import com.example.progetto_ispw.model.Questionario;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class QuestionarioDAO {

    Connection connection;

    /**
     * Costruttore che inizializza la connessione al database.
     *
     * @param connection la connessione al database.
     */
    protected QuestionarioDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Recupera una lista di questionari dal database per l'utente corrente.
     *
     * @return una lista di oggetti Questionario contenenti i dati letti dal database.
     */
    protected ArrayList<Questionario> getQuestionarios() {
        ArrayList<Questionario> questionarios = new ArrayList<>();
        CallableStatement callablestatement = null;
        String email = MasterController.getInstance().getCurrentUser().getEmail();
        try {
            callablestatement = this.connection.prepareCall("call getquestionari(?);");
            callablestatement.setString(1, email);
            callablestatement.execute();
            ResultSet resultSet = callablestatement.getResultSet();
            while (resultSet.next()) {
                Questionario questionario = new Questionario(
                        resultSet.getString(1),
                        resultSet.getString(4),
                        resultSet.getString(2),
                        new ArrayList<>(Arrays.asList(resultSet.getString(3).split("\\|")))
                );
                questionarios.add(questionario);
            }
            return questionarios;
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     * Registra la risposta di un utente a un questionario nel database.
     *
     * @param codiceQuest il codice identificativo del questionario.
     * @param risposta la risposta dell'utente.
     * @param email l'email dell'utente che ha votato.
     * @return true se la votazione è stata registrata correttamente, false altrimenti.
     */
    protected boolean votedQuest(String codiceQuest, String risposta, String email){

        CallableStatement cs = null;
        try {
            cs = connection.prepareCall("{call voteQuest(?,?,?)}");

            cs.setString(1, codiceQuest);
            cs.setString(2, risposta);
            cs.setString(3, email);

            cs.executeQuery();

        } catch (SQLException e) {
            // Gestione degli errori durante l'esecuzione della votazione
            throw new RuntimeException(e);
        } finally {
            if (cs != null) {
                try {
                    cs.close();  // Chiudere lo Statement per liberare risorse
                } catch (SQLException e) {
                }
            }
        }
        return true;
    }
}
