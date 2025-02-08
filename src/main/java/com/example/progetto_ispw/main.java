package com.example.progetto_ispw;

import com.example.progetto_ispw.dao.DBConnectionDAO;
import com.example.progetto_ispw.view.MasterView;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.Screen;

public class main extends Application {
    /**
     * Metodo principale di JavaFX chiamato al lancio dell'applicazione.
     * Configura la dimensione dello stage e mostra la vista iniziale
     * ovvero richiama la MasterView e lancia la general login view.
     *
     * @param stage Lo stage principale dell'applicazione
     * @throws Exception nel caso si verificasse un errore durante l'avvio
     */
    @Override
    public void start(Stage stage) throws Exception {

        // Ottieni le dimensioni dello schermo
        double screenWidth = Screen.getPrimary().getBounds().getWidth();
        double screenHeight = Screen.getPrimary().getBounds().getHeight();

        // Calcola 3/4 delle dimensioni dello schermo
        double stageWidth = screenWidth * 0.75;
        double stageHeight = screenHeight * 0.75;

        // Imposta le dimensioni dello stage
        stage.setWidth(stageWidth);
        stage.setHeight(stageHeight);

        MasterView masterView = MasterView.getInstance();
        masterView.setStage(stage);
        masterView.showLoginUserView();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
