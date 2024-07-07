package com.example.progetto_ispw.controller;


import com.example.progetto_ispw.model.Questionario;
import com.example.progetto_ispw.model.Statistiche;

import java.util.ArrayList;

public class MasterController {
    private static MasterController instance;
    private Questionario questionario;


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
        Questionario q = new Questionario(codice, argomento, domanda, possibiliRisposte, listaStatistiche);
        listaQuest.add(q);
        String codice2 = "002";
        String argomento2 = "tempo libero";
        String domanda2 = "preferisci mare o montagna?";
        ArrayList<String> possibiliRisposte2 = new ArrayList<>();
        possibiliRisposte.add("mare");
        possibiliRisposte.add("montagna");
        Statistiche statistiche2 = new Statistiche();
        statistiche.addCategoria("stato", "italia");
        //quante persone hanno votato la risposta
        statistiche.addRisposte("mare", 200);
        statistiche.addRisposte("montagna", 100);
        ArrayList<Statistiche> listaStatistiche2 = new ArrayList<>();
        listaStatistiche2.add(statistiche2);
        Questionario q2 = new Questionario(codice2, argomento2, domanda2, possibiliRisposte2, listaStatistiche2);
        listaQuest.add(q2);
        return listaQuest;
    }

    public Questionario getQuestionario() {
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
}
