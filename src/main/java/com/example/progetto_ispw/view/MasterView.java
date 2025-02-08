package com.example.progetto_ispw.view;

import javafx.stage.Stage;

/**
 * MasterView è una classe sviluppata con pattern singleton
 * che permette la visualizzazione di tutte le schermate della applicazione.
 * ogni volta che si apre una nuova pagina, si richiede alla master view di aprire la classe corrispondente,
 * la quale si occuperà di popolare correttamente tutte le box
 */
public class MasterView {
    private Stage stage;
    private static MasterView instance;
    private MasterView() {
    }

    public static MasterView getInstance() {
        if(instance==null) {
            instance = new MasterView();
        }
        return instance;
    }

    public void setStage(Stage stage){
        this.stage = stage;
    }

    /**
     * Mostra la vista di login per l'utente normale.
     * Consente agli utenti di loggarsi nel sistema.
     */
    public void showLoginView() {
        LoginUserView luv = new LoginUserView();
        try {
            luv.start(this.stage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Mostra la vista di login interno.
     * Consente agli utenti di inserire un token per accedere come addetti ai lavori.
     */
    /*public void showInternalLoginView() {
        LoginInternalView liv = new LoginInternalView();
        try {
            liv.start(this.stage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }*/

    /**
     * Mostra la vista generale del login.
     * Permette di selezionare la modalità di accesso (utente normale o addetto ai lavori).
     * Questa vista è visibile solo in ambiente di test per mostrare tutte le opzioni.
     * L'utente finale vedrà solo la pagina di login standard.
     */
    public void showGeneralLoginView() {
        GeneralLoginView glv = new GeneralLoginView();
        try {
            glv.start(this.stage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Mostra la vista di registrazione utente.
     * Consente agli utenti di registrarsi sulla piattaforma.
     */
    public void showRegistrazioneUserView() {
        RegistrazioneUserView ruv = new RegistrazioneUserView();
        try {
            ruv.start(this.stage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Mostra la vista della scheda personale.
     * Visualizza i dati salvati sulla piattaforma relativi all'utente.
     */
    public void showSchedaPersonaleView() {
        SchedaPersonaleView spv = new SchedaPersonaleView();
        try {
            spv.start(this.stage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Mostra la vista della home page.
     * Permette di accedere a opzioni come la ricerca del questionario,
     * la visualizzazione delle statistiche, suggerimenti di questionari consigliati,
     * e la visualizzazione della propria scheda personale.
     */
    public void showHomePageView() {
        HomePageView hpv = new HomePageView();
        try {
            hpv.start(this.stage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Mostra la vista del questionario.
     * Consente agli utenti di compilare e gestire i questionari.
     */
    public void showQuestionarioView() {
        QuestionarioView qv = new QuestionarioView();
        try {
            qv.start(this.stage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void showCollabsView() {
        CollabsView cv = new CollabsView();
        try {
            cv.start(this.stage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void showNonTrovatoView() {
        NonTrovatoView nt = new NonTrovatoView();
        try {
            nt.start(this.stage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /*public void showRicercaView() {
        RicercaView cv = new RicercaView();
        try {
            cv.start(this.stage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }*/
}
