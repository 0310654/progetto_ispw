package com.example.progetto_ispw.controller;


import com.example.progetto_ispw.model.Questionario;
import com.example.progetto_ispw.model.Statistiche;
import com.example.progetto_ispw.model.User;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public class MasterController {
    private static MasterController instance;
    private Questionario questionario;
    private User user;
    private ArrayList<Questionario> collabs;



    private MasterController() {}

    public static MasterController getInstance() {
        if(instance==null) {
            instance = new MasterController();
        }
        return instance;
    }

    public boolean login(String email, String password) {
        //TODO
        return true;
    }

    public boolean internalLogin(String token) {
        //TODO
        return true;
    }

    public ArrayList<Questionario> getQuestSearched() {
        //TODO creare arraylist di questionari in base alla ricerca
        ArrayList<Questionario> listaQuest = new ArrayList<>();
        createQuest();
        listaQuest.add(this.questionario);
        listaQuest.add(this.questionario);
        return listaQuest;
    }

    public Questionario getQuestionario() {
        //TODO
        createQuest();
        return questionario;
    }

    public void votedQuest(String risposta) {
        //TODO
        System.out.println(risposta);
    }

    public void goToQuest(Questionario q) {
        //TODO
        System.out.println("Seleziono " + q.getDomanda());
    }

    public void nextQuest() {
       //TODO
        System.out.println("carico prossimo questionario");
    }

    public User getCurrentUser() {
        //TODO
        createUser();
        return user;
    }

    private void createQuest(){
        String codice = "001";
        String argomento = "animali";
        String domanda = "preferisci i cani o i gatti?";
        ArrayList<String> possibiliRisposte = new ArrayList<>();
        possibiliRisposte.add("cani");
        possibiliRisposte.add("gatti");
        Statistiche statistiche = new Statistiche();
        statistiche.addCategoria("stato", "italia");
        //quante persone hanno votato la risposta
        statistiche.addRisposte("cani", 200);
        statistiche.addRisposte("gatti", 100);
        ArrayList<Statistiche> listaStatistiche = new ArrayList<>();
        listaStatistiche.add(statistiche);
        this.questionario = new Questionario(codice, argomento, domanda, possibiliRisposte, listaStatistiche);

    }

    private void createUser(){
        String username = "pippo"; //Il nome utente univoco scelto dall'utente.
        String nome = "pippo ciao";
        String email = "pippo@gmail.com";
        String password = "pass";
        String cellulare = "333";
        String dataDiNascita = "2020-03-03";
        String bio = "ciao";
        this.user = new User(username, nome, email, password, cellulare, dataDiNascita, bio);
    }

    public void recuperaCollab() {
        //TODO
        createQuest();
        ArrayList<Questionario> listaQuest = new ArrayList<>();
        listaQuest.add(this.questionario);
        this.collabs = listaQuest;
    }

    public ArrayList<Pair> getCollabs() {
        //TODO
        createQuest();
        Pair<Questionario, String> collab = new Pair<>( this.questionario, "pippo");
        ArrayList<Pair> collabs = new ArrayList<>();
        collabs.add(collab);
        return collabs;
    }
}
