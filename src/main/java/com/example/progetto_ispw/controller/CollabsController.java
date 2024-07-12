package com.example.progetto_ispw.controller;

import com.example.progetto_ispw.model.Questionario;
import javafx.util.Pair;

import java.util.ArrayList;

public class CollabsController {

    private Questionario questionario;
    private ArrayList<Questionario> collabs;

    public void recuperaCollab() {
        //TODO
        QuestionarioController.getInstance().createQuest();
        ArrayList<Questionario> listaQuest = new ArrayList<>();
        listaQuest.add(this.questionario);
        this.collabs = listaQuest;
    }

    public ArrayList<Pair> getCollabs() {
        //TODO
        QuestionarioController.getInstance().createQuest();
        Pair<Questionario, String> collab = new Pair<>( this.questionario, "pippo");
        ArrayList<Pair> collabs = new ArrayList<>();
        collabs.add(collab);
        return collabs;
    }
}
