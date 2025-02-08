package com.example.progetto_ispw.view;
import com.example.progetto_ispw.controller.MasterController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.*;

public class CollabsView extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage stage) {

        this.primaryStage = stage;
        primaryStage.setTitle("Collaborazioni");
        primaryStage.setWidth(300);
        primaryStage.setHeight(500);

        ObservableList<AbstractMap.SimpleEntry<String, String>> collabs = FXCollections.observableArrayList(MasterController.getInstance().getCollabs());
        for (AbstractMap.SimpleEntry<String, String> collab : collabs) {
            System.out.println(collab.getKey() + " " + collab.getValue());
        }
        VBox vbox = new VBox(10);
        for (AbstractMap.SimpleEntry<String, String> pair : collabs) {
            // Crea le etichette per ogni coppia domanda/risposta
            Label domandaLabel = new Label("Domanda : \"" + pair.getKey() + "\"");
            Label rispostaLabel = new Label("La tua risposta : \"" + pair.getValue() + "\"");
            vbox.getChildren().addAll(domandaLabel, rispostaLabel);
        }

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(vbox);
        scrollPane.setFitToWidth(true);

        Scene scene = new Scene(scrollPane, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}



