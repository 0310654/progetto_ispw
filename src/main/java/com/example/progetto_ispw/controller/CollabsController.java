package com.example.progetto_ispw.controller;

import com.example.progetto_ispw.dao.MasterDAO;
import com.example.progetto_ispw.model.Questionario;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

public class CollabsController {

    //private Questionario questionario;
    //private ArrayList<Questionario> collabs;

    /*public void recuperaCollab() {
        //TODO
        QuestionarioController.getInstance().createQuest();
        ArrayList<Questionario> listaQuest = new ArrayList<>();
        listaQuest.add(this.questionario);
        this.collabs = listaQuest;
    }*/

    public List<AbstractMap.SimpleEntry<String, String>> getCollabs(String email) {
        return MasterDAO.getInstance().getCollabs(email);

    }

}
