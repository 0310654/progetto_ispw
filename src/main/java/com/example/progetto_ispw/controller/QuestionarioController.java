package com.example.progetto_ispw.controller;

import com.example.progetto_ispw.dao.MasterDAO;
import com.example.progetto_ispw.model.Questionario;
import com.example.progetto_ispw.model.Statistiche;
import com.example.progetto_ispw.model.User;

import java.util.ArrayList;

public class QuestionarioController {

    private Questionario questionario;

    private static QuestionarioController instance;
    private ArrayList<Questionario> collabs;
    private ArrayList<Questionario> questionarios;
    private int currentQuest;

    private QuestionarioController() {
        this.questionarios = MasterDAO.getInstance().getQuestionarios();
        currentQuest = 0;
    }

    public static QuestionarioController getInstance() {
        if(instance==null) {
            instance = new QuestionarioController();
        }
        return instance;
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
        if (questionarios == null || currentQuest >= questionarios.size()) {
            return null;
        }
        else {
            Questionario q = questionarios.get(currentQuest);
            currentQuest ++;
            return q ;
        }
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

    public void createQuest(){
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
        this.questionario = new Questionario(codice, argomento, domanda, possibiliRisposte);
    }



}
