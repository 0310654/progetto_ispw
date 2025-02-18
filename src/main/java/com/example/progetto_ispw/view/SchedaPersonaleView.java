package com.example.progetto_ispw.view;

import com.example.progetto_ispw.controller.MasterController;
import com.example.progetto_ispw.model.User;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class SchedaPersonaleView extends Application {
    private Stage primaryStage;

    public SchedaPersonaleView() {
    }

    /**
     * funzione che permette all'utente di visualizzare la scheda personale.
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        this.primaryStage = stage;
        User user = MasterController.getInstance().getCurrentUser();

        /**
         * Titolo della pagina, siamo nella scheda personale dell'utente
         */
        primaryStage.setTitle("Scheda Personale");

        Label usernameLabel = new Label("Username: " + user.getUsername());
        Label bioLabel = new Label("Bio: " + user.getBio());

        Button questionariCollaboratiButton = new Button("Questionari a cui hai collaborato");
        Button backButton = new Button("Torna alla home page");

        /**
         * premendo il bottone delle collabs, ci porta alla loro view
         */
        questionariCollaboratiButton.setOnAction(event -> {
            MasterView masterView = MasterView.getInstance();
            masterView.showCollabsView();
        });

        /**
         * premendo il backbutton è possibile tornare alla HomePageView
         */
        backButton.setOnAction(event -> {
            MasterView masterView = MasterView.getInstance();
            masterView.showHomePageView();
        });

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20, 20, 20, 20));
        vbox.getChildren().addAll( usernameLabel, bioLabel, questionariCollaboratiButton, backButton);

        /**
         * ScrollPane che ci da la possibilità di scorrere la pagina senza bisogno di espanderla
         */
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(vbox);
        scrollPane.setFitToWidth(true);

        //setto la scena
        Scene scene = new Scene(scrollPane);
        stage.setScene(scene);
        stage.show();
    }

}
