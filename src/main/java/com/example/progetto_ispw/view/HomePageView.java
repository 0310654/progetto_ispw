package com.example.progetto_ispw.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomePageView extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Homepage");

        Label domandaLabel = new Label("Salve! Cosa vuoi fare oggi?:");
        Label searchLabel = new Label("Inserisci il testo da cercare:");
        TextField searchField = new TextField();
        searchField.setPromptText("Inserisci il testo qui");

        Button schedaPersonaleButton = new Button("La tua scheda");
        Button votaButton = new Button("Rispondi ai questionari consigliati");
        Button statisticheButton = new Button("Visualizza qualche statistica");
        Button searchButton = new Button("Cerca");
        Label resultLabel = new Label();

        schedaPersonaleButton.setOnAction(event -> {
            MasterView masterView = MasterView.getInstance(stage);
            masterView.showSchedaPersonaleView();
        });

        votaButton.setOnAction(event -> {
            MasterView masterView = MasterView.getInstance(stage);
            //TODO crea showQuestionarioView
            //masterView.showQuestionarioView();
        });
        statisticheButton.setOnAction(event -> {
            MasterView masterView = MasterView.getInstance(stage);
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

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20, 20, 20, 20));
        vbox.getChildren().addAll(domandaLabel, searchLabel, searchField, schedaPersonaleButton, votaButton, statisticheButton, searchButton, resultLabel
        );

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(vbox);
        scrollPane.setFitToWidth(true);

        Scene scene = new Scene(vbox, 300, 200);
        stage.setScene(scene);
        stage.show();
    }

    private void performSearch(String searchText, Label resultLabel) {
        resultLabel.setText("Hai cercato: " + searchText);
    }
}
