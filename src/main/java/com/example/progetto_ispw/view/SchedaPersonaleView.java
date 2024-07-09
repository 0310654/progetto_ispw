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


    public SchedaPersonaleView() {
    }

    private String username;
    private String bio;
    private ArrayList<String> questionariCollaborati;
    private ArrayList<String> questionariCondivisi;

    @Override
    public void start(Stage stage) throws Exception {

        User user = MasterController.getInstance().getCurrentUser();

        stage.setTitle("Scheda");

        Label usernameLabel = new Label(user.getUsername());
        Label bioLabel = new Label(user.getBio());

        /*Button modificaBioButton = new Button("Modifica bio");
        modificaBioButton.setOnAction(event -> {
            //TODO
        });*/

        Button questionariCollaboratiButton = new Button("Questionari a cui hai collaborato");
        Button backButton = new Button("Torna alla home page");

        backButton.setOnAction(event -> {
            MasterView masterView = MasterView.getInstance();
            masterView.showHomePageView();
        });

        // Gestore dell'evento del bottone
        questionariCollaboratiButton.setOnAction(event -> {
            MasterController.getInstance().recuperaCollab();
            MasterView.getInstance().showCollabsView();
        });



        // Layout
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20, 20, 20, 20));
        vbox.getChildren().addAll(usernameLabel, bioLabel, questionariCollaboratiButton);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(vbox);
        scrollPane.setFitToWidth(true);

        // Scena
        Scene scene = new Scene(scrollPane, 300, 200);
        stage.setScene(scene);
        stage.show();
    }

}
