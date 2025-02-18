package com.example.progetto_ispw.view;

import com.example.progetto_ispw.controller.MasterController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomePageView extends Application {

    /**
     * funzione che permette all'utente di visualizzare la home page.
     * @param stage
     */

    @Override
    public void start(Stage stage) {
        stage.setTitle("Homepage");

        // Ottengo l'istanza del MasterController, che gestisce la logica principale dell'applicazione
        MasterController masterController = MasterController.getInstance();

        Label domandaLabel = new Label("Salve! Cosa vuoi fare oggi?");
        // Imposto lo stile della label (dimensione del font e grassetto)
        domandaLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Label searchLabel = new Label("Inserisci il testo da cercare:");
        TextField searchField = new TextField();
        searchField.setPromptText("Inserisci il testo qui");

        Button schedaPersonaleButton = new Button("La tua scheda");
        Button votaButton = new Button("Rispondi ai questionari consigliati");

        Button searchButton = new Button("Cerca");
        // Imposto una larghezza predefinita per il pulsante di ricerca
        searchButton.setPrefWidth(100);

        Label resultLabel = new Label();

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
            // Ottengo il testo inserito dall'utente nel campo di ricerca
            String ricerca = searchField.getText();
            // Controllo sul campo di ricerca
            if (ricerca.isEmpty()) {
                resultLabel.setText("Per favore, inserisci testo da cercare.");
            }
            else if (!ricerca.matches("[a-zA-Z0-9 ]*")) {
                resultLabel.setText("Caratteri non validi, per favore riprova");
            }
            else {
                // Passa la ricerca al controller per eseguire la ricerca dei questionari
                masterController.searchQuest(ricerca);
                // Mostro la vista dei questionari in base ai risultati della ricerca
                MasterView.getInstance().showQuestionarioView();
            }
        });

        Button backButton = new Button("Torna alla home page");
        backButton.setOnAction(event -> {
            MasterView masterView = MasterView.getInstance();
            masterView.showHomePageView();
        });

        HBox titleBox = new HBox(domandaLabel);
        titleBox.setAlignment(Pos.CENTER);
        titleBox.setPadding(new Insets(20));

        HBox searchBar = new HBox(10, searchField, searchButton);
        searchBar.setAlignment(Pos.CENTER);
        searchBar.setPrefWidth(Double.MAX_VALUE);

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(30));
        gridPane.setHgap(20);
        gridPane.setVgap(20);

        gridPane.add(domandaLabel, 1,0);
        gridPane.add(searchLabel, 0, 2);
        gridPane.add(searchField, 1, 2);
        gridPane.add(schedaPersonaleButton, 0, 3);
        gridPane.add(votaButton, 0, 4);
        gridPane.add(searchButton, 2, 2);
        gridPane.add(resultLabel, 0,5);

        GridPane.setHalignment(domandaLabel, javafx.geometry.HPos.CENTER);
        GridPane.setHalignment(resultLabel, javafx.geometry.HPos.CENTER);

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
