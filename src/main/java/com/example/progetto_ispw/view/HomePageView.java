package com.example.progetto_ispw.view;

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
            MasterView masterView = MasterView.getInstance();
            //TODO crea showQuestionarioView
            //masterView.showQuestionarioView();
        });

        statisticheButton.setOnAction(event -> {
            MasterView masterView = MasterView.getInstance();
            //TODO crea showStatisticheView
            //masterView.showStatisticheView();
        });

        searchButton.setOnAction(event -> {
            String searchText = searchField.getText();

            if (searchText.isEmpty()) {
                resultLabel.setText("Per favore, inserisci del testo da cercare.");
            } else {
                performSearch(searchText, resultLabel);
            }
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

    private void performSearch(String searchText, Label resultLabel) {
        resultLabel.setText("Hai cercato: " + searchText);
    }
}
