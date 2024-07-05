package com.example.progetto_ispw.model;

import com.example.progetto_ispw.model.Questionario;
import com.example.progetto_ispw.model.User;

import java.util.Vector;

public class SchedaUtente extends User {
    private String codiceScheda;

    //TODO questionari svolti è un array list dove mettere il codice dei questionari a cui ha risposto lo user
    //private String questionariSvolti;
    private Vector<Questionario> questionariSvolti;
    public SchedaUtente (String username, String nome, String email, String password, String cellulare, String dataDiNascita, String bio, String codiceScheda, Vector<Questionario> questionariSvolti) {
        super(username, nome, email, password, cellulare, dataDiNascita, bio);
        this.questionariSvolti = questionariSvolti;
        this.codiceScheda = codiceScheda;
    }

    public String getCodiceScheda(){
        return this.codiceScheda;
    }

    public void setCodiceScheda(String codiceScheda){
        this.codiceScheda = codiceScheda;
    }
    public Vector<Questionario> getQuestionariSvolti(){
        return this.questionariSvolti;
    }

    public void setQuestionariSvolti(Vector<Questionario> questionariSvolti){
        this.questionariSvolti = questionariSvolti;
    }

}
