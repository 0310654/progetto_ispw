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


/**
 * Classe che rappresenta la vista di login per l'utente.
 * Permette agli utenti di inserire le proprie credenziali per accedere al sistema.
 */
public class LoginUserView extends Application {
    private Stage primaryStage;

    public LoginUserView() {
    }

    /**
     * funzione che permette all'utente di entrare nella home page.
     * vengono richieste email e password, e i dati vengono confrontati con quanto presente nel database
     * sfruttando la funzione login del master controller
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {

        this.primaryStage = stage;

        primaryStage.setTitle("Login User");

        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();
        emailField.setPromptText("Inserisci la tua email");

        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Inserisci la tua password");

        Button loginButton = new Button("Login");
        Label messageLabel = new Label();
        Button registrationButton = new Button("Registrati");

        // Gestore dell'evento del bottone di login
        loginButton.setOnAction(event -> {
            String email = emailField.getText();
            String password = passwordField.getText();

            if (email.isEmpty() || password.isEmpty()) {
                messageLabel.setText("Per favore, compila tutti i campi.");
            } else {
                boolean utenteTrovato = MasterController.getInstance().login(email, password);
                if (utenteTrovato) {
                    MasterView.getInstance().showHomePageView();
                } else {
                    messageLabel.setText("Credenziali non valide. Riprova.");
                }
            }
        });

        // Gestore dell'evento del bottone di registrazione
        registrationButton.setOnAction(event -> {
            MasterView masterView = MasterView.getInstance();
            masterView.showRegistrazioneUserView();
        });

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20, 20, 20, 20));
        Scene scene = new Scene(vbox, 300, 200);
        vbox.getChildren().addAll(emailLabel, emailField, passwordLabel, passwordField, loginButton, registrationButton, messageLabel);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

