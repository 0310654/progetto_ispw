package com.example.progetto_ispw.view;

import com.example.progetto_ispw.controller.MasterController;
import com.example.progetto_ispw.model.Questionario;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomePageView extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Homepage");

        MasterController masterController = MasterController.getInstance();

        // Creating Labels, TextField, and Buttons
        Label domandaLabel = new Label("Salve! Cosa vuoi fare oggi?:");
        Label searchLabel = new Label("Inserisci il testo da cercare:");
        TextField searchField = new TextField();
        searchField.setPromptText("Inserisci il testo qui");

        Button schedaPersonaleButton = new Button("La tua scheda");
        Button votaButton = new Button("Rispondi ai questionari consigliati");
        Button statisticheButton = new Button("Visualizza qualche statistica");
        Button searchButton = new Button("Cerca");
        Label resultLabel = new Label();

        // Setting button actions
        schedaPersonaleButton.setOnAction(event -> {
            MasterView masterView = MasterView.getInstance();
            masterView.showSchedaPersonaleView();
        });

        votaButton.setOnAction(event -> {
            MasterController.getInstance().disattivaRicerca();
            MasterView masterView = MasterView.getInstance();
            masterView.showQuestionarioView();
        });

        searchButton.setOnAction(event -> {
            String ricerca = searchField.getText();
            if (ricerca.isEmpty()) {
                resultLabel.setText("Per favore, inserisci testo da cercare.");
            } else {
                masterController.searchQuest(ricerca);
                MasterView.getInstance().showQuestionarioView();
            }
        });

        Button backButton = new Button("Torna alla home page");
        backButton.setOnAction(event -> {
            MasterView masterView = MasterView.getInstance();
            masterView.showHomePageView();
        });


        // Creating layout with GridPane
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Adding elements to the GridPane
        gridPane.add(domandaLabel, 0, 0, 2, 1);
        gridPane.add(searchLabel, 0, 1);
        gridPane.add(searchField, 1, 1);
        gridPane.add(schedaPersonaleButton, 0, 4);
        gridPane.add(votaButton, 1, 3);
        gridPane.add(statisticheButton, 0, 3);
        gridPane.add(searchButton, 2, 1);
        gridPane.add(resultLabel, 0, 4, 2, 1);

        // Aligning elements
        GridPane.setHalignment(domandaLabel, javafx.geometry.HPos.CENTER);
        GridPane.setHalignment(resultLabel, javafx.geometry.HPos.CENTER);

        // Creating a VBox to hold the GridPane
        VBox vbox = new VBox(gridPane);
        vbox.setAlignment(Pos.CENTER);

        // Creating a ScrollPane to make the UI scrollable
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(vbox);
        scrollPane.setFitToWidth(true);

        // Setting the scene
        Scene scene = new Scene(scrollPane, 400, 300);
        stage.setScene(scene);
        // Adatta le dimensioni dello stage al contenuto della scena
        stage.sizeToScene();
        stage.show();
    }


    //private void performSearch(String searchText, Label resultLabel) {
        //resultLabel.setText("Hai cercato: " + searchText);
   // }
}
