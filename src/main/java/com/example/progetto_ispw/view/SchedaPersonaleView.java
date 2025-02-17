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

    @Override
    public void start(Stage stage) throws Exception {
        this.primaryStage = stage;
        User user = MasterController.getInstance().getCurrentUser();

        primaryStage.setTitle("Scheda Personale");

        Label usernameLabel = new Label("Username: " + user.getUsername());
        Label bioLabel = new Label("Bio: " + user.getBio());

        Button questionariCollaboratiButton = new Button("Questionari a cui hai collaborato");
        Button backButton = new Button("Torna alla home page");
        //Button modificaBioButton = new Button("Modifica bio");

        questionariCollaboratiButton.setOnAction(event -> {
            MasterView masterView = MasterView.getInstance();
            masterView.showCollabsView();
        });

        backButton.setOnAction(event -> {
            MasterView masterView = MasterView.getInstance();
            masterView.showHomePageView();
        });

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20, 20, 20, 20));
        vbox.getChildren().addAll( usernameLabel, bioLabel, questionariCollaboratiButton, backButton);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(vbox);
        scrollPane.setFitToWidth(true);

        Scene scene = new Scene(scrollPane);
        stage.setScene(scene);
        stage.show();
    }

}
