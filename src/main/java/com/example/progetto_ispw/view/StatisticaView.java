package com.example.progetto_ispw.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class StatisticaView extends Application{
    private Stage primaryStage;

    public StatisticaView() {
    }

    @Override
    public void start(Stage stage) throws Exception {

        this.primaryStage = stage;


        primaryStage.setTitle("Statistica");

        Label domandaLabel = new Label("preferisci i cani o i gatti");
        Label rispostaALabel = new Label("cani");
        Label rispostaBLabel = new Label("gatti");
        Label percALabel = new Label("60%");
        Label percBLabel = new Label("40%");

        Button interestedButton = new Button("Interessante");
        Button backButton = new Button("Torna alla home page");
        Label messageLabel = new Label();


        interestedButton.setOnAction(event -> {
            //TODO aggiungere questa statistica in quelle d'interessa/piaciute nella scheda personale
        });

        backButton.setOnAction(event -> {
            MasterView masterView = MasterView.getInstance(primaryStage);
            masterView.showHomePageView();
        });

        // Layout
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20, 20, 20, 20));
        vbox.getChildren().addAll(domandaLabel, rispostaALabel, rispostaBLabel, percALabel, percBLabel, backButton, messageLabel );

        // Scena
        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
