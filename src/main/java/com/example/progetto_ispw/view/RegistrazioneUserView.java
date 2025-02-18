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

    // Objects
    /**
     * username dello user
     */
    private String username;
    /**
     * nome proprio dello user
     */
    private String nome;
    /**
     * email dello user, univoca per ogni utente
     */
    private String email;
    /**
     * password dello user
     */
    private String password;
    /**
     * cellulare dello user
     */
    private String cellulare;
    /**
     * data di nascita dello user, dato utile per le statistiche
     */
    private String dataDiNascita;
    /**
     * nazionalità dello user, dato utile per le statistiche
     */
    private String nazionalita;
    /**
     * sesso dello user, dato utile per le statistiche
     */
    private String sesso;
    /**
     * bio dello user, impronta verso lo stile di un social network
     */
    private String bio;

    /**
     * funzione che permette all'utente di registrarsi.
     * vengono richiesti gli object sopra descritti, e i dati vengono inseriti nel database
     * sfruttando la funzione registrazione del master controller
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {

        this.primaryStage = stage;
        ArrayList<String> result = new ArrayList<>();

        primaryStage.setTitle("Registrazione");

        // Creazione di un'etichetta per il campo username
        Label usernameLabel = new Label("Username:");
        // Creazione di un campo di testo per l'inserimento dell'username
        TextField usernameField = new TextField();
        /**
         * Imposto un testo di suggerimento nel campo di testo per guidare l'utente
         */
        usernameField.setPromptText("Inserisci un username univoco");

        // Creazione di un'etichetta per il campo nome
        Label nameLabel = new Label("Nome Utente:");
        // Creazione di un campo di testo per l'inserimento del nome
        TextField nameField = new TextField();
        /**
         * Imposto un testo di suggerimento nel campo di testo per guidare l'utente
         */
        nameField.setPromptText("Inserisci il nome con cui ti conosceranno gli altri utenti");

        // Creazione di un'etichetta per il campo email
        Label emailLabel = new Label("Email:");
        // Creazione di un campo di testo per l'inserimento dell'email
        TextField emailField = new TextField();
        /**
         * Imposto un testo di suggerimento nel campo di testo per guidare l'utente
         */
        emailField.setPromptText("Inserisci la tua email");

        // Creazione di un'etichetta per il campo password
        Label passwordLabel = new Label("Password:");
        // Creazione di un campo di testo per l'inserimento della password
        PasswordField passwordField = new PasswordField();
        /**
         * Imposto un testo di suggerimento nel campo di testo per guidare l'utente
         */
        passwordField.setPromptText("Inserisci la tua password");

        // Creazione di un'etichetta per il campo cellulare
        Label cellulareLabel = new Label("Cellulare:");
        // Creazione di un campo di testo per l'inserimento del cellulare
        TextField cellulareField = new TextField();
        /**
         * Imposto un testo di suggerimento nel campo di testo per guidare l'utente
         */
        cellulareField.setPromptText("Inserisci il tuo numero di cellulare");

        // Creazione di un'etichetta per il campo data di nascita
        Label dataDiNascitaLabel = new Label("Data di nascita:");
        // Creazione di un campo di testo per l'inserimento della data di nascita
        TextField dataDiNascitaField = new TextField();
        /**
         * Imposto un testo di suggerimento nel campo di testo per guidare l'utente
         */
        dataDiNascitaField.setPromptText("Inserisci la tua data di nascita del tipo YY-MM-GG");

        // Creazione di un'etichetta per il campo nazionalità
        Label nazionalitaLabel = new Label("Nazionalità:");
        // Creazione di un campo di testo per l'inserimento della nazionalità
        TextField nazionalitaField = new TextField();
        /**
         * Imposto un testo di suggerimento nel campo di testo per guidare l'utente
         */
        nazionalitaField.setPromptText("Inserisci la tua nazionalità");

        // Creazione di un'etichetta per il campo seso
        Label sessoLabel = new Label("Sesso:");
        // Creazione di un campo di testo per l'inserimento del sesso
        TextField sessoField = new TextField();
        /**
         * Imposto un testo di suggerimento nel campo di testo per guidare l'utente
         */
        sessoField.setPromptText("Inserisci il tuo sesso");

        // Creazione di un'etichetta per il campo bio
        Label bioLabel = new Label("Bio:");
        // Creazione di un campo di testo per l'inserimento della bio
        TextField bioField = new TextField();
        /**
         * Imposto un testo di suggerimento nel campo di testo per guidare l'utente
         */
        bioField.setPromptText("Inserisci una bio che ti rappresenti (Opzionale)");

        // Bottone di registrazione
        Button loginButton = new Button("Registrazione");
        Label messageLabel = new Label();

        /**
         * premendo il backbutton è possibile tornare indietro
         */
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
        Button loginButton = new Button("Login");
        loginButton.setOnAction(event -> {
            MasterView masterView = MasterView.getInstance();
            masterView.showLoginUserView();
        });

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20, 20, 20, 20));
        vbox.getChildren().addAll(successLabel, loginButton);
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
        Button riprovaButton = new Button("Riprova");
        riprovaButton.setOnAction(event -> {
            MasterView masterView = MasterView.getInstance();
            masterView.showRegistrazioneUserView();
        });

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20, 20, 20, 20));
        vbox.getChildren().addAll(errorLabel, riprovaButton);
        Scene errorScene = new Scene(vbox, 300, 200);
        primaryStage.setScene(errorScene);
        primaryStage.show();
    }
}
