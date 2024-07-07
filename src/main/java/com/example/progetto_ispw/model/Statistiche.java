package com.example.progetto_ispw.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Statistiche {

    HashMap<String, String> categoria;
    HashMap<String, Integer> risposte;

    public Statistiche (){
        categoria = new HashMap<>();
        risposte = new HashMap<>();
    }

    public HashMap<String, String> getCategoria() {
        return this.categoria;
    }
    public HashMap<String, Integer> getRisposte(){
        return this.risposte;
    }

    public void addCategoria(String chiave, String valore) {
        this.categoria.put(chiave, valore);
    }
    public void addRisposte(String chiave, int valore) {
        this.risposte.put(chiave, valore);
    }


}
