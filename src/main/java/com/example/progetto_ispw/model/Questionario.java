package com.example.progetto_ispw.model;

import java.util.ArrayList;

public class Questionario {
    private String codice;
    private String argomento;
    private String domanda;
    private ArrayList<String> possibiliRisposte;
    //private ArrayList<Statistiche> statistiche;

    public Questionario (String codice, String argomento, String domanda, ArrayList<String> possibiliRisposte){
        this.codice = codice;
        this.argomento = argomento;
        this.domanda = domanda;
        this.possibiliRisposte = possibiliRisposte;
        //this.statistiche = statistiche;

    }
    public String getCodice(){
        return this.codice;
    }
    public void setCodice(String codice){
        this.codice = codice;
    }
    public String getArgomento(){
        return this.argomento;
    }
    public void setArgomento(String argomento){
        this.argomento = argomento;
    }
    public String getDomanda(){
        return this.domanda;
    }
    public void setDomanda(String domanda){
        this.domanda = domanda;
    }
    public ArrayList<String> getPossibiliRisposte(){
        return this.possibiliRisposte;
    }
    public void setPossibiliRisposte(ArrayList<String> possibiliRisposte){
        this.possibiliRisposte = possibiliRisposte;
    }
    /*public ArrayList<Statistiche> getStatistiche(){
        return this.statistiche;
    }
    public void setStatistiche(ArrayList<Statistiche> statistiche){
        this.statistiche = statistiche;
    }*/
}