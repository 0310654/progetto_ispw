package com.example.progetto_ispw.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class QuestionarioView extends Application {

    private Stage primaryStage;

    public QuestionarioView() {
    }

    @Override
    public void start(Stage stage) throws Exception {

        this.primaryStage = stage;
        ArrayList<String> risposte = new ArrayList<>();


        primaryStage.setTitle("Questionario");

        Label domandaLabel = new Label("preferisci i cani o i gatti");

        Button rispostaAButton = new Button("Cane");
        Button rispostaBButton = new Button("Gatto");
        Button confirmationButton = new Button("Conferma la risposta");
        Button backButton = new Button("Torna alla home page");
        Label messageLabel = new Label();


        rispostaAButton.setOnAction(event -> {
            //TODO aggiungere al corrispettivo questionario un array di risposte cosi poi poterne calcolare la statistica

        });

        rispostaBButton.setOnAction(event -> {
            //TODO aggiungere al corrispettivo questionario un array di risposte cosi poi poterne calcolare la statistica

        });

        confirmationButton.setOnAction(event -> {
                messageLabel.setText("Votazione confermata");
        });
        backButton.setOnAction(event -> {
            MasterView masterView = MasterView.getInstance(primaryStage);
            masterView.showHomePageView();
        });

        // Layout
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20, 20, 20, 20));
        vbox.getChildren().addAll(domandaLabel, rispostaAButton, rispostaBButton, confirmationButton, backButton, messageLabel );

        // Scena
        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
