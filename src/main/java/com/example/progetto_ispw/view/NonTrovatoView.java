package com.example.progetto_ispw.view;

import com.example.progetto_ispw.controller.MasterController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NonTrovatoView extends Application {

    @Override
    public void start(Stage stage) {

        Label avvisoLabel = new Label("Non abbiamo trovato questionari corrispondenti alla tua ricerca");

        /**
         * pulsante per tornare alla home page.
         * Quando il pulsante viene cliccato, disabilita la modalità
         * di ricerca e mostra la home page.
         */
        Button homePageButton = new Button("Torna alla home");
        homePageButton.setOnAction(event -> {
            MasterController.getInstance().disattivaRicerca();
            MasterView masterView = MasterView.getInstance();
            masterView.showHomePageView();
        });

        /**
         * Crea un pulsante per rispondere ai questionari consigliati.
         * Quando il pulsante viene cliccato, disabilita la ricerca e mostra la vista dei questionari.
         */
        Button votaButton = new Button("Rispondi ai questionari consigliati");
        votaButton.setOnAction(event -> {
            MasterController.getInstance().disattivaRicerca();
            MasterView masterView = MasterView.getInstance();
            masterView.showQuestionarioView();
        });

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        gridPane.add(avvisoLabel, 0, 0, 2, 1);
        gridPane.add(votaButton, 1, 3);
        gridPane.add(homePageButton, 0, 4, 2, 1);

        GridPane.setHalignment(avvisoLabel, javafx.geometry.HPos.CENTER);

        VBox vbox = new VBox(gridPane);
        vbox.setAlignment(Pos.CENTER);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(vbox);
        scrollPane.setFitToWidth(true);

        Scene scene = new Scene(scrollPane);
        stage.setScene(scene);

        stage.show();
    }
}

