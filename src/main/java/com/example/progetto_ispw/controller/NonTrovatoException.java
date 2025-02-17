package com.example.progetto_ispw.controller;

import com.example.progetto_ispw.view.MasterView;

public class NonTrovatoException extends Exception {
    public NonTrovatoException(String avviso){
        super(avviso);
        MasterView masterView = MasterView.getInstance();
        masterView.showNonTrovatoView();
    }
}
