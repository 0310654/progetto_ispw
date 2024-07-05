package com.example.progetto_ispw.model;

public class UtenteInterno {
    private String nome;
    private String cognome;
    private String email;
    private String cellulare;

    public UtenteInterno (String nome, String cognome, String email, String cellulare){
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.cellulare = cellulare;
    }
    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCognome(){
        return this.cognome;
    }

    public void setCognome(String cognome){
        this.cognome = cognome;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getCellulare(){
        return this.cellulare;
    }

    public void setCellulare(String cellulare){
        this.cellulare = cellulare;
    }
}
