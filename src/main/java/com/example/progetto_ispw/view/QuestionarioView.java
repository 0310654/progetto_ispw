package com.example.progetto_ispw.view;

import com.example.progetto_ispw.controller.MasterController;
import com.example.progetto_ispw.controller.QuestionarioController;
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
    private Stage stage;
    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        stage.setTitle("Questionario");

        MasterController masterController = MasterController.getInstance();
        Questionario questionario = masterController.getQuestionario();


        if (questionario != null) {

            VBox vbox = new VBox(10);
            Label domandaLabel = new Label(questionario.getDomanda());
            vbox.setPadding(new Insets(20, 20, 20, 20));
            vbox.getChildren().addAll(domandaLabel);

            //per ogni risposta possibile mi creo un bottone, se lo clicco...
            for (String risposta : questionario.getPossibiliRisposte()) {
                System.out.println(risposta);
                Button voteButton = new Button(risposta);
                voteButton.setOnAction(event -> {
                    //prendi la risposta del bottone che ho schiacciato e mettila dentro votedQuest(risposta) qui sotto
                    System.out.println(risposta);
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

            Button skipButton = new Button("Prossima domanda");
            skipButton.setOnAction(event -> {
                MasterController.getInstance().nextQuest();
                MasterView.getInstance().showQuestionarioView();
            });

            vbox.getChildren().addAll(backButton, skipButton);

            // Scena
            Scene scene = new Scene(vbox, 300, 200);
            stage.setScene(scene);
            stage.show();


        }

    }

}
