package com.example.progetto_ispw.model;


public class User {

    private String username; //Il nome utente univoco scelto dall'utente.
    private String nome; //Il nome reale o visualizzato dell'utente.
    private String email;
    private String password;
    private String cellulare;
    private String dataDiNascita;
    private String nazionalita;
    private String sesso;
    private String bio;

    public User(String username,
                String nome,
                String email,
                String password,
                String cellulare,
                String dataDiNascita,
                String nazionalita,
                String sesso,
                String bio) {
        this.username = username;
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.cellulare = cellulare;
        this.dataDiNascita = dataDiNascita;
        this.nazionalita = nazionalita;
        this.sesso = sesso;
        this.bio = bio;
    }


    public String getUsername(){
        return this.username;
    }

    public void setUsername(String username){
        this.username = username;
    }
    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }


    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public void getPass(String password){
        this.password = password;
    }
    public void setPass(String password){
        this.password = password;
    }

    public String getCellulare(){
        return this.cellulare;
    }

    public void setCellulare(String cellulare){
        this.cellulare = cellulare;
    }

    public String getDataDiNascita(){
        return this.dataDiNascita;
    }

    public void setDataDiNascita(String dataDiNascita){
        this.dataDiNascita = dataDiNascita;
    }

    public String getNazionalita(){
        return this.nazionalita;
    }

    public void setNazionalita(String nazionalita){
        this.nazionalita = nazionalita;
    }

    public String getSesso(){
        return this.sesso;
    }

    public void setSesso(String sesso){
        this.sesso = sesso;
    }

    public String getBio(){
        return this.bio;
    }

    public void setBio(String bio){
        this.bio = bio;
    }
}
