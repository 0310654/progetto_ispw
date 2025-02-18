package com.example.progetto_ispw.controller;


import com.example.progetto_ispw.model.Questionario;
import com.example.progetto_ispw.model.User;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

/**
 * MasterController è una classe sviluppata con pattern singleton e facade
 * che reindirizza al controller specifico utile per l'operazione da compiere.
 * ogni volta che si clicca un bottone per fare qualcosa, si richiede alla Master Controller di richiamare la classe corrispondente,
 * la quale si occuperà di chiamare il Master Dao
 */
public class MasterController {

    private static MasterController instance;
    //Costruttore privato per impedire l'istanza diretta della classe dall'esterno.
    private MasterController() {}

    /**
     * Restituisce l'istanza unica della classe MasterController (pattern singleton ).
     *
     * @return l'istanza del MasterController
     */
    public static MasterController getInstance() {
        if(instance==null) {
            instance = new MasterController();
        }
        return instance;
    }

    public boolean login(String email, String password) {
        return LoginUserController.getInstance().login(email, password);
    }

    public boolean registrazioneUser(ArrayList<String> result) {
        String username = result.get(0);
        String nome  = result.get(1);
        String email = result.get(2);
        String password = result.get(3);
        String cellulare = result.get(4);
        String dataDiNascita = result.get(5);
        String nazionalita = result.get(6);
        String sesso = result.get(7);
        String bio = result.get(8);
        return UserController.getInstance().registrazioneUser(username, nome,  email,  password,  cellulare, dataDiNascita, nazionalita, sesso, bio);
    }

    //restituisce il questionario a cui voglio votare
    public Questionario getQuestionario() {
        return QuestionarioController.getInstance().getQuestionario();
    }

    //ho votato: salva la mia risposta
    public boolean votedQuest(String risposta) {
        String email = getCurrentUser().getEmail();
        return QuestionarioController.getInstance().votedQuest(risposta, email);
    }

    public void nextQuest() {
        QuestionarioController.getInstance().nextQuest();
    }

    public User getCurrentUser() {
        return LoginUserController.getInstance().getUser();
    }

    /**
     * Restituisce la lista delle collaborazioni per l'utente corrente.
     *
     * @return una lista di coppie (chiave, valore) delle collaborazioni dell'utente
     */
    public List<AbstractMap.SimpleEntry<String, String>> getCollabs() {
        CollabsController cc = new CollabsController();
        String email = getCurrentUser().getEmail();
        return cc.getCollabs(email);
    }

    public void disattivaRicerca() {
        QuestionarioController.getInstance().disattivaRicerca();
    }


    public void searchQuest(String resultLabel) {
        QuestionarioController.getInstance().cercaQuest(resultLabel);
    }

}
