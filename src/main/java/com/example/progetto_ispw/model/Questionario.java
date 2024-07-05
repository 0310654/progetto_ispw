package com.example.progetto_ispw.model;

public class Questionario {
    private String codice;
    private String argomento;
    public Questionario (String codice, String argomento){
        this.codice = codice;
        this.argomento = argomento;
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
}