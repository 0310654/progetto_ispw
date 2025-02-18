package com.example.progetto_ispw.view;

import com.example.progetto_ispw.controller.MasterController;
import com.example.progetto_ispw.model.Questionario;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.ScrollPane;


public class QuestionarioView extends Application {
    private Stage stage;
    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        stage.setTitle("Questionario");

        // Ottengo l'istanza del MasterController, che gestisce la logica principale dell'applicazione
        MasterController masterController = MasterController.getInstance();

        // Recupero il questionario attualmente attivo, che verrà mostrato all'utente
        Questionario questionario = masterController.getQuestionario();

        if (questionario != null) {

            VBox vbox = new VBox(10);
            Label domandaLabel = new Label(questionario.getDomanda());
            // Imposto lo stile dell'etichetta: testo in grassetto e dimensione del font
            domandaLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");
            vbox.setPadding(new Insets(20, 20, 20, 20));
            vbox.getChildren().addAll(domandaLabel);

            /**
             * Itera su tutte le possibili risposte del questionario e crea un pulsante
             * per ogni risposta disponibile
             */
            for (String risposta : questionario.getPossibiliRisposte()) {
                Button voteButton = new Button(risposta);
                voteButton.setOnAction(event -> {
                    /**
                     * Registro la risposta selezionata dall'utente nel sistema, per passare
                     * alla prossima domanda del questionario: aggiorno la vista per mostrare
                     * la nuova domanda all'utente
                     * @param risposta la risposta selezionata dall'utente
                     */
                    masterController.votedQuest(risposta);
                    MasterController.getInstance().nextQuest();
                    MasterView.getInstance().showQuestionarioView();
                });
                vbox.getChildren().add(voteButton);
            }

            Button backButton = new Button("Torna alla home page");
            backButton.setOnAction(event -> {
                MasterView masterView = MasterView.getInstance();
                masterView.showHomePageView();
            });

            /**
             * passo alla prossima domanda del questionario: aggiorno la vista per mostrare
             * la nuova domanda all'utente
             */
            Button skipButton = new Button("Prossima domanda");
            skipButton.setOnAction(event -> {
                MasterController.getInstance().nextQuest();
                MasterView.getInstance().showQuestionarioView();
            });

            HBox navigationBox = new HBox(10);
            navigationBox.setPadding(new Insets(10, 0, 0, 0));

            navigationBox.getChildren().addAll(backButton, skipButton);
            vbox.getChildren().add(navigationBox);

            ScrollPane scrollPane = new ScrollPane(vbox);
            scrollPane.setFitToWidth(true);

            //set scene
            Scene scene = new Scene(scrollPane);
            stage.setScene(scene);
            stage.show();
        }
    }
}
