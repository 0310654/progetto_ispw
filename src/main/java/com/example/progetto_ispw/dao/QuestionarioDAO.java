package com.example.progetto_ispw.dao;

import com.example.progetto_ispw.controller.MasterController;
import com.example.progetto_ispw.model.Questionario;

import java.sql.*;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestionarioDAO {

    Connection connection;

    protected QuestionarioDAO(Connection connection) {
        this.connection = connection;
    }

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
            System.err.println("Errore " + e.getMessage());
            return null;
        }
    }

    protected boolean votedQuest(String codiceQuest, String risposta, String email){

        CallableStatement cs = null;
        try {
            cs = connection.prepareCall("{call voteQuest(?,?,?)}");

            cs.setString(1, codiceQuest);
            cs.setString(2, risposta);
            cs.setString(3, email);

            cs.executeQuery();

        } catch (SQLException e) {
            System.err.println("errore nella votazione: " + e.getMessage());
            throw new RuntimeException(e);
        } finally {
            if (cs != null) {
                try {
                    cs.close();  // Chiudi sempre lo Statement per liberare risorse
                } catch (SQLException e) {
                    System.err.println("Errore durante la chiusura dello statement: " + e.getMessage());
                }
            }
        }
        System.out.println("votato correttamente");
        return true;
    }

}
