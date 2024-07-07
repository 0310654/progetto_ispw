package com.example.progetto_ispw.view;

import com.example.progetto_ispw.controller.MasterController;
import com.example.progetto_ispw.model.Questionario;
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

public class QuestionarioView extends Application {


    @Override
    public void start(Stage stage) throws Exception {

        MasterController masterController = MasterController.getInstance();
        Questionario questionario = masterController.getQuestionario();

        stage.setTitle("Questionario");

        Label domandaLabel = new Label(questionario.getDomanda());

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20, 20, 20, 20));
        vbox.getChildren().add(domandaLabel);
        for (String risposta: questionario.getPossibiliRisposte()) {
            Button voteButton = new Button(risposta);
            voteButton.setOnAction(event -> {
                //TODO
                masterController.votedQuest(risposta);
            });
            vbox.getChildren().add(voteButton);
        }

        Button backButton = new Button("Torna alla home page");
        Button skipButton = new Button("Prossima domanda");

        backButton.setOnAction(event -> {
            MasterView masterView = MasterView.getInstance();
            masterView.showHomePageView();
        });

        skipButton.setOnAction(event -> {
            MasterController.getInstance().nextQuest();
            MasterView.getInstance().showQuestionarioView();
        });

        vbox.getChildren().addAll(backButton, skipButton );

        // Scena
        Scene scene = new Scene(vbox, 300, 200);
        stage.setScene(scene);
        stage.show();
    }

}
