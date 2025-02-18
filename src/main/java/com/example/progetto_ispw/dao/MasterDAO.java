package com.example.progetto_ispw.dao;

import com.example.progetto_ispw.model.Questionario;

import java.sql.Connection;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

/**
 * MasterDAO è una classe sviluppata con pattern singleton
 * che gestisce le operazioni principali relative al database.
 */
public class MasterDAO {

    private static MasterDAO instance;
    private Connection connection;

    /**
     * Costruttore privato che inizializza la connessione al database.
     * La connessione viene ottenuta tramite la classe DBConnectionDAO.
     */
    private MasterDAO() {
        this.connection = DBConnectionDAO.getInstance().getConnection();
    }

    /**
     * Metodo che restituisce l'istanza singleton di MasterDAO.
     *
     * @return l'istanza unica di MasterDAO.
     */
    public static MasterDAO getInstance() {
        if(instance==null) {
            instance = new MasterDAO();
        }
        return instance;
    }

    /**
     * Esegue il login dell'utente verificando la sua email e password.
     *
     * @param email l'email dell'utente che tenta di effettuare il login.
     * @param password la password dell'utente che tenta di effettuare il login.
     * @return una lista contenente i dati dell'utente se il login è riuscito, altrimenti una lista vuota.
     */
    public ArrayList<String> loginUser(String email, String password) {
        LoginUserDAO lud = new LoginUserDAO(connection);
        return lud.loginUser(email, password);
    }

    /**
     * Recupera una lista di questionari per l'utente corrente.
     *
     * @return una lista di oggetti Questionario letti dal database.
     */
    public ArrayList<Questionario> getQuestionarios() {
        QuestionarioDAO qd = new QuestionarioDAO(connection);
        return qd.getQuestionarios();
    }

    /**
     * Registra una risposta di un utente a un questionario.
     *
     * @param codiceQuest il codice identificativo del questionario.
     * @param risposta la risposta fornita dall'utente.
     * @param email l'email dell'utente che ha risposto.
     * @return true se la risposta è stata registrata correttamente, false altrimenti.
     */
    public boolean votedQuest(String codiceQuest, String risposta, String email) {
        QuestionarioDAO qd = new QuestionarioDAO(connection);
        return qd.votedQuest(codiceQuest, risposta, email);
    }

    /**
     * Registra un nuovo utente nel sistema.
     *
     * @param username il nome utente scelto.
     * @param nome il nome dell'utente.
     * @param email l'email dell'utente.
     * @param password la password scelta dall'utente.
     * @param cellulare il numero di cellulare dell'utente.
     * @param dataDiNascita la data di nascita dell'utente.
     * @param nazionalita la nazionalità dell'utente.
     * @param sesso il sesso dell'utente.
     * @param bio una breve biografia dell'utente.
     * @return true se la registrazione è riuscita, false altrimenti.
     */
    public boolean  registrazioneUser(String username, String nome, String email, String password, String cellulare, String dataDiNascita, String nazionalita, String sesso, String bio) {
        LoginUserDAO ud = new LoginUserDAO(connection);
        return ud.registrazioneUser(username,nome,email, password, cellulare,dataDiNascita,nazionalita,sesso,bio);
    }

    /**
     * Recupera una lista di collaborazioni per l'utente con l'email specificata.
     *
     * @param email l'email dell'utente per il quale si vogliono ottenere le collaborazioni.
     * @return una lista di oggetti AbstractMap.SimpleEntry contenente coppie domanda/risposta per le collaborazioni.
     */
    public List<AbstractMap.SimpleEntry<String, String>> getCollabs(String email) {
        CollabsDAO cd = new CollabsDAO(connection);
        return cd.getCollabs(email);
    }

}

