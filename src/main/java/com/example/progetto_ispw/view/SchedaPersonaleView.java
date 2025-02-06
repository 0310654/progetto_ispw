package com.example.progetto_ispw.view;

import com.example.progetto_ispw.controller.MasterController;
import com.example.progetto_ispw.model.Questionario;
import com.example.progetto_ispw.model.User;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class SchedaPersonaleView extends Application {
    private Stage primaryStage;

    public SchedaPersonaleView() {
    }

    private String username;
    private String bio;
    private ArrayList<String> questionariCollaborati;

    @Override
    public void start(Stage stage) throws Exception {
        this.primaryStage = stage;
        User user = MasterController.getInstance().getCurrentUser();

        primaryStage.setTitle("Scheda Personale");

        Label usernameLabel = new Label("Username: " + user.getUsername());

        Label bioLabel = new Label("Bio: " + user.getBio());


        Button questionariCollaboratiButton = new Button("Questionari a cui hai collaborato");
        Button backButton = new Button("Torna alla home page");
        Button modificaBioButton = new Button("Modifica bio");


        // Gestore dell'evento del bottone
        questionariCollaboratiButton.setOnAction(event -> {
            MasterView masterView = MasterView.getInstance();
            masterView.showCollabsView();
        });

        //BACKBUTTON
        backButton.setOnAction(event -> {
            MasterView masterView = MasterView.getInstance();
            masterView.showHomePageView();
        });


      //TODO: tasto per modificare la bio
        modificaBioButton.setOnAction(event -> {
        });

        // Layout
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20, 20, 20, 20));
        //TODO aggiungi backbutton
        vbox.getChildren().addAll( usernameLabel, bioLabel, questionariCollaboratiButton, modificaBioButton);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(vbox);
        scrollPane.setFitToWidth(true);

        // Scena
        Scene scene = new Scene(scrollPane, 300, 200);
        stage.setScene(scene);
        stage.show();
    }

}
