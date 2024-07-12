package com.example.progetto_ispw.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class QuestionarioDAO {

    Connection connection;

    public void QuestionarioDAO(Connection connection) {
        this.connection = MasterDAO.getConnection();
    }

    /*public boolean inseriscoOreEffettive (String giorno, String mese, String anno, String ore_coperte_effettive, String cf_impiegato  ) {

        String call = " { call inserisco_ore_effettive(?, ?, ?,?, ? ) } ";

        try (CallableStatement callablestatement = connection.prepareCall(call)) {
            callablestatement.setString(1, giorno);
            callablestatement.setString(2, mese);
            callablestatement.setString(3, anno);
            callablestatement.setString(4, ore_coperte_effettive);
            callablestatement.setString(5, cf_impiegato);
            callablestatement.execute();
            System.out.println("Fatto! Le ore svolte sono state modificate correttamente");
            return true;
        } catch (SQLException e) {
            System.err.println("Errore durante la modifica dell'orario: " + e.getMessage());
            return false;
        }
    }*/

}
