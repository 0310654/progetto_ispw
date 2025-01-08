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
import javafx.scene.control.ScrollPane;


import java.util.ArrayList;

public class RegistrazioneUserView extends Application {
    private Stage primaryStage;

    public RegistrazioneUserView() {
    }

    private String nome; //Il nome reale o visualizzato dell'utente.
    private String email;
    private String password;
    private String cellulare;
    private String dataDiNascita;
    private String bio;

    @Override
    public void start(Stage stage) throws Exception {

        this.primaryStage = stage;
        ArrayList<String> result = new ArrayList<>();

        primaryStage.setTitle("Registrazione");

        // Creazione dei campi di input
        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        usernameField.setPromptText("Inserisci un username univoco");

        Label nameLabel = new Label("Nome Utente:");
        TextField nameField = new TextField();
        nameField.setPromptText("Inserisci il nome con cui ti conosceranno gli altri utenti");

        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();
        emailField.setPromptText("Inserisci la tua email");

        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Inserisci la tua password");

        Label cellulareLabel = new Label("Cellulare:");
        TextField cellulareField = new TextField();
        cellulareField.setPromptText("Inserisci il tuo numero di cellulare");

        Label dataDiNascitaLabel = new Label("Data di nascita:");
        TextField dataDiNascitaField = new TextField();
        dataDiNascitaField.setPromptText("Inserisci la tua data di nascita");

        Label bioLabel = new Label("Bio:");
        TextField bioField = new TextField();
        bioField.setPromptText("Inserisci una bio che ti rappresenti (Opzionale)");

        // Bottone di login
        Button loginButton = new Button("Registrazione");
        Label messageLabel = new Label();

        // Gestore dell'evento del bottone di login
        loginButton.setOnAction(event -> {
            String username = usernameField.getText();
            String name = nameField.getText();
            String email = emailField.getText();
            String password = passwordField.getText();
            String cellulare = cellulareField.getText();
            String dataDiNascita = dataDiNascitaField.getText();
            String bio = bioField.getText();

            if (username.isEmpty() || name.isEmpty() || email.isEmpty() || password.isEmpty() || cellulare.isEmpty() || dataDiNascita.isEmpty()) {
                messageLabel.setText("Per favore, compila tutti i campi.");
            } else {
                validateregistration();
            }
        });

        // Layout
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20, 20, 20, 20));
        vbox.getChildren().addAll(usernameLabel,usernameField, nameLabel, nameField, emailLabel, emailField, passwordLabel, passwordField, cellulareLabel, cellulareField, dataDiNascitaLabel, dataDiNascitaField, bioLabel, bioField, loginButton, messageLabel);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(vbox);
        scrollPane.setFitToWidth(true);

        // Scena
        Scene scene = new Scene(scrollPane, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Metodo per la validazione delle credenziali di login
    //TODO
    private void validateregistration() {
        showSuccessScreen();
    }

    private void showSuccessScreen() {
        Label successLabel = new Label("Successo, registrazione effettuata");
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20, 20, 20, 20));
        vbox.getChildren().add(successLabel);

        Scene successScene = new Scene(vbox, 300, 200);
        primaryStage.setScene(successScene);
        primaryStage.show();
    }
}
