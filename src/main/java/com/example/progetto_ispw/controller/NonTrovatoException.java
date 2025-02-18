package com.example.progetto_ispw.controller;

import com.example.progetto_ispw.view.MasterView;

/**
 * Classe che rappresenta un'eccezione personalizzata, NonTrovatoException.
 * Viene lanciata quando l'operazione di ricerca non mostra risultati compatibili.
 */
public class NonTrovatoException extends Exception {
    /**
     * Costruttore della classe che accetta un messaggio di avviso e lo passa al costruttore della superclasse (Exception).
     * Inoltre, viene visualizzata una vista specifica per l'eccezione.
     *
     * @param avviso il messaggio di avviso che descrive il motivo dell'eccezione
     */
    public NonTrovatoException(String avviso){
        // Passa il messaggio di avviso alla classe padre
        super(avviso);
        MasterView masterView = MasterView.getInstance();
        masterView.showNonTrovatoView();
    }
}
