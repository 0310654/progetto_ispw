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

public class GeneralLoginView extends Application {
    @Override
    public void start(Stage stage) throws Exception {


        stage.setTitle("Scelta login");

        // Creazione dei campi di input
        Label domandaLabel = new Label("Che tipo di utente sei?:");

        // Bottone di login
        Button loginButtonUser = new Button("User");
        Button loginButtonInternal = new Button("Utente interno");

        // Gestore dell'evento del bottone di login
        loginButtonUser.setOnAction(event -> {
            MasterView masterView = MasterView.getInstance();
            masterView.showLoginView();
        });

        loginButtonInternal.setOnAction(event -> {
            MasterView masterView = MasterView.getInstance();
            masterView.showInternalLoginView();
        });

        //TODO cancella
        Button directlogin = new Button("login diretto");
        directlogin.setOnAction(event -> {
            MasterView masterView = MasterView.getInstance();
            masterView.showHomePageView();
        });

        // Layout
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20, 20, 20, 20));
        vbox.getChildren().addAll(domandaLabel, loginButtonUser, loginButtonInternal, directlogin);

        // Scena
        Scene scene = new Scene(vbox, 300, 200);
        stage.setScene(scene);
        stage.show();
    }



}
