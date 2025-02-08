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
     * Mostra la vista di login per l'utente.
     * Consente agli utenti di loggarsi nel sistema.
     */
    public void showLoginUserView() {
        LoginUserView luv = new LoginUserView();
        try {
            luv.start(this.stage);
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

    /**
     * Mostra la vista dei questionari a cui l'utente ha collaborato.
     * Consente agli utenti di ripercorrere lo storico sull'applicazione ricordando le risposte date in precedenza.
     */
    public void showCollabsView() {
        CollabsView cv = new CollabsView();
        try {
            cv.start(this.stage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Mostra la vista della pagina di incompatibilità nella ricerca.
     * Consente agli utenti di tornare alla home page oppure di votare ai questionari consigliati dal sistema.
     */
    public void showNonTrovatoView() {
        NonTrovatoView nt = new NonTrovatoView();
        try {
            nt.start(this.stage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
