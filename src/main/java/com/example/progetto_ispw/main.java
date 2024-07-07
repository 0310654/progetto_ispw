package com.example.progetto_ispw;

import com.example.progetto_ispw.view.MasterView;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.Screen;

public class main extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        /*// Ottieni le dimensioni dello schermo
        double screenWidth = Screen.getPrimary().getBounds().getWidth();
        double screenHeight = Screen.getPrimary().getBounds().getHeight();

        // Calcola 3/4 delle dimensioni dello schermo
        double stageWidth = screenWidth * 0.75;
        double stageHeight = screenHeight * 0.75;

        // Imposta le dimensioni dello stage
        stage.setWidth(stageWidth);
        stage.setHeight(stageHeight);*/

        MasterView masterView = MasterView.getInstance();
        masterView.setStage(stage);
        masterView.showGeneralLoginView();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
