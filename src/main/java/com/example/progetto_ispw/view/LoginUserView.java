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
import java.util.Random;

import static javafx.application.Application.launch;

public class LoginUserView extends Application {
    private Stage primaryStage;

    public LoginUserView() {
    }

    @Override
    public void start(Stage stage) throws Exception {

        this.primaryStage = stage;
        ArrayList<String> result = new ArrayList<>();

        primaryStage.setTitle("Login User");

        // Creazione dei campi di input
        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();
        emailField.setPromptText("Inserisci la tua email");

        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Inserisci la tua password");

        // Bottone di login
        Button loginButton = new Button("Login");
        Label messageLabel = new Label();

        // Gestore dell'evento del bottone di login
        loginButton.setOnAction(event -> {
            String email = emailField.getText();
            String password = passwordField.getText();

            if (email.isEmpty() || password.isEmpty()) {
                messageLabel.setText("Per favore, compila tutti i campi.");
            } else {
                if (validateLogin(email, password)) {
                    showSuccessScreen();
                } else {
                    messageLabel.setText("Credenziali non valide. Riprova.");
                }
            }
        });

        // Layout
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20, 20, 20, 20));
        vbox.getChildren().addAll(emailLabel, emailField, passwordLabel, passwordField, loginButton, messageLabel);

        // Scena
        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Metodo per la validazione delle credenziali di login
    private boolean validateLogin(String email, String password) {
        // Sostituisci con la tua logica di autenticazione
        return email.equals("test") && password.equals("password");
    }

    private void showSuccessScreen() {
        Label successLabel = new Label("Successo, login effettuato");
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20, 20, 20, 20));
        vbox.getChildren().add(successLabel);

        Scene successScene = new Scene(vbox, 300, 200);
        primaryStage.setScene(successScene);
        primaryStage.show();
    }


}

