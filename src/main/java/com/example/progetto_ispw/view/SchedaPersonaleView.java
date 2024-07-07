package com.example.progetto_ispw.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class SchedaPersonaleView extends Application {

    private Stage stage;

    public SchedaPersonaleView() {
    }

    private String username;
    private String bio;
    private ArrayList<String> questionariCollaborati;
    private ArrayList<String> questionariCondivisi;

    @Override
    public void start(Stage stage) throws Exception {

        this.stage = stage;
        ArrayList<String> result = new ArrayList<>();

        stage.setTitle("Scheda");

        Label usernameLabel = new Label("Nome: " + "username");
        Label bioLabel = new Label("Email: " + "bio");

        // Bottone
        Button questionariCollaboratiButton = new Button("Questionari a cui hai collaborato");
        Button questionariCondivisiButton = new Button("Questionari che hai condiviso");
        Button modificaBioButton = new Button("Modifica bio");
        Label messageLabel = new Label();

        // Gestore dell'evento del bottone
        questionariCollaboratiButton.setOnAction(event -> {
            //TODO mostrare i questionari che saranno aggiunti tramite funzione specifica: "addQuestionariCollaborati"
        });

        questionariCondivisiButton.setOnAction(event -> {
            //TODO mostrare i questionari che saranno aggiunti tramite funzione specifica: "addQuestionariCondivisi"
        });
        modificaBioButton.setOnAction(event -> {
        });

        // Layout
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20, 20, 20, 20));
        vbox.getChildren().addAll(usernameLabel, bioLabel, messageLabel);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(vbox);
        scrollPane.setFitToWidth(true);

        // Scena
        Scene scene = new Scene(scrollPane, 300, 200);
        stage.setScene(scene);
        stage.show();
    }

}
