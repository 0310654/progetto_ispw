package com.example.progetto_ispw.view;

import com.example.progetto_ispw.controller.MasterController;
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

    private String username;
    private String nome;
    private String email;
    private String password;
    private String cellulare;
    private String dataDiNascita;
    private String nazionalita;
    private String sesso;
    private String bio;

    @Override
    public void start(Stage stage) throws Exception {

        this.primaryStage = stage;
        ArrayList<String> result = new ArrayList<>();

        primaryStage.setTitle("Registrazione");

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

        Label nazionalitaLabel = new Label("Nazionalità:");
        TextField nazionalitaField = new TextField();
        nazionalitaField.setPromptText("Inserisci la tua nazionalità");

        Label sessoLabel = new Label("Sesso:");
        TextField sessoField = new TextField();
        sessoField.setPromptText("Inserisci il tuo sesso");

        Label bioLabel = new Label("Bio:");
        TextField bioField = new TextField();
        bioField.setPromptText("Inserisci una bio che ti rappresenti (Opzionale)");

        // Bottone di login
        Button loginButton = new Button("Registrazione");
        Label messageLabel = new Label();

        Button backButton = new Button("Annulla");
        backButton.setOnAction(event -> {
            MasterView masterView = MasterView.getInstance();
            masterView.showLoginUserView();
        });

        // Gestore dell'evento del bottone di login
        loginButton.setOnAction(event -> {
            username = usernameField.getText();
            nome = nameField.getText();
            email = emailField.getText();
            password = passwordField.getText();
            cellulare = cellulareField.getText();
            dataDiNascita = dataDiNascitaField.getText();
            nazionalita = nazionalitaField.getText();
            sesso = sessoField.getText();
            bio = bioField.getText();

            if (username.isEmpty() || nome.isEmpty() || email.isEmpty() || password.isEmpty() || cellulare.isEmpty() || dataDiNascita.isEmpty() || nazionalita.isEmpty() || sesso.isEmpty()) {
                messageLabel.setText("Per favore, compila tutti i campi.");
            } else {
                result.add(username);
                result.add(nome);
                result.add(email);
                result.add(password);
                result.add(cellulare);
                result.add(dataDiNascita);
                result.add(nazionalita);
                result.add(sesso);
                result.add(bio);
                validateregistration(result);
            }
        });

        // Layout
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20, 20, 20, 20));
        vbox.getChildren().addAll(usernameLabel,usernameField, nameLabel, nameField, emailLabel, emailField, passwordLabel, passwordField, cellulareLabel, cellulareField, dataDiNascitaLabel, dataDiNascitaField, nazionalitaLabel, nazionalitaField, sessoLabel, sessoField, bioLabel, bioField, loginButton, messageLabel, backButton);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(vbox);
        scrollPane.setFitToWidth(true);

        Scene scene = new Scene(scrollPane, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Metodo per la validazione delle credenziali di login.
     * Consente agli utenti di capire se la registrazione è andata a buon fine o meno.
     */
    private void validateregistration(ArrayList<String> result) {
        if (MasterController.getInstance().registrazioneUser(result)) {
            showSuccessScreen();
        }
        else {
            showFailScreen();
        }
    }

    /**
     * Schermata di successo.
     * Consente agli utenti di capire che la registrazione è andata a buon fine.
     */
    private void showSuccessScreen() {
        Label successLabel = new Label("Successo, registrazione effettuata");
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20, 20, 20, 20));
        vbox.getChildren().add(successLabel);

        Scene successScene = new Scene(vbox, 300, 200);
        primaryStage.setScene(successScene);
        primaryStage.show();
    }

    /**
     * Schermata di errore.
     * Consente agli utenti di capire che la registrazione non è andata a buon fine.
     */
    private void showFailScreen() {
        Label errorLabel = new Label("La registrazione non è andata a buon fine, per favore riprova");
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20, 20, 20, 20));
        vbox.getChildren().add(errorLabel);
        Scene errorScene = new Scene(vbox, 300, 200);
        primaryStage.setScene(errorScene);
        primaryStage.show();
    }
}
