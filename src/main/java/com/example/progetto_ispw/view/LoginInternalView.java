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

public class LoginInternalView extends Application {

    private Stage primaryStage;

    public LoginInternalView() {
    }

    @Override
    public void start(Stage stage) throws Exception {

        this.primaryStage = stage;
        ArrayList<String> result = new ArrayList<>();

        primaryStage.setTitle("Login User Interno");

        // Creazione dei campi di input
        Label tokenLabel = new Label("Token:");
        TextField tokenField = new TextField();
        tokenField.setPromptText("Inserisci token di accesso:");

        // Bottone di login
        Button loginButton = new Button("Login");
        Label messageLabel = new Label();

        // Gestore dell'evento del bottone di login
        loginButton.setOnAction(event -> {
            String token = tokenField.getText();

            if (token.isEmpty()) {
                messageLabel.setText("Per favore, compila il campo.");
            } else {
                if (validateLogin(token)) {
                    showSuccessScreen();
                } else {
                    messageLabel.setText("Credenziali non valide. Riprova.");
                }
            }
        });

        // Layout
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20, 20, 20, 20));
        vbox.getChildren().addAll(tokenLabel, tokenField, loginButton, messageLabel);

        // Scena
        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Metodo per la validazione delle credenziali di login
    private boolean validateLogin(String token) {
        // Sostituisci con la tua logica di autenticazione
        return token.equals("test");
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
