package com.example.progetto_ispw.model;

import java.util.ArrayList;

public class Questionario {
    private String codice;
    private String argomento;
    private String domanda;
    private ArrayList<String> possibiliRisposte;

    public Questionario (String codice, String argomento, String domanda, ArrayList<String> possibiliRisposte){
        this.codice = codice;
        this.argomento = argomento;
        this.domanda = domanda;
        this.possibiliRisposte = possibiliRisposte;
    }
    public String getCodice(){
        return this.codice;
    }

    public String getArgomento(){
        return this.argomento;
    }

    public String getDomanda(){
        return this.domanda;
    }

    public ArrayList<String> getPossibiliRisposte(){
        return this.possibiliRisposte;
    }
}