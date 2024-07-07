package com.example.progetto_ispw.view;

import com.example.progetto_ispw.controller.MasterController;
import com.example.progetto_ispw.model.Questionario;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class RicercaView extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        MasterController masterController = MasterController.getInstance();
        ArrayList<Questionario> listaQuest = masterController.getQuestSearched();

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20, 20, 20, 20));

        for (Questionario q : listaQuest) {
            // Argomento in grassetto
            Label argomentoLabel = new Label(q.getArgomento());
            argomentoLabel.setStyle("-fx-font-weight: bold;");

            Label domandaLabel = new Label(q.getDomanda());

            Button voteButton = new Button("Vota");
            voteButton.setOnAction(event -> {
                //TODO: voglio andare alla view di votazione del questionario q
                masterController.goToQuest(q);
                MasterView.getInstance().showQuestionarioView();
            });

            VBox questionBox = new VBox(5);
            questionBox.getChildren().addAll(argomentoLabel, domandaLabel, voteButton);
            vbox.getChildren().addAll(questionBox, new Separator());
        }
        Scene scene = new Scene(vbox, 400, 300);
        stage.setScene(scene);
        stage.show();
    }

}
