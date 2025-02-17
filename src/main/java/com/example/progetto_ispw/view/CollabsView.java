package com.example.progetto_ispw.view;
import com.example.progetto_ispw.controller.MasterController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.*;

public class CollabsView extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage stage) {

        this.primaryStage = stage;
        primaryStage.setTitle("Collaborazioni");
        //primaryStage.setWidth(300);
        //primaryStage.setHeight(500);

        ObservableList<AbstractMap.SimpleEntry<String, String>> collabs = FXCollections.observableArrayList(MasterController.getInstance().getCollabs());
        for (AbstractMap.SimpleEntry<String, String> collab : collabs) {
            System.out.println(collab.getKey() + " " + collab.getValue());
        }
        VBox vbox = new VBox(10);
        for (AbstractMap.SimpleEntry<String, String> pair : collabs) {
            // Crea le etichette per ogni coppia domanda/risposta
            Label domandaLabel = new Label("Domanda : \"" + pair.getKey() + "\"");
            Label rispostaLabel = new Label("La tua risposta : \"" + pair.getValue() + "\"");
            rispostaLabel.setStyle("-fx-font-weight: bold;");
            vbox.getChildren().addAll(domandaLabel, rispostaLabel, new Separator());
        }

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().add(vbox);
        AnchorPane.setTopAnchor(vbox, 50.0); // Distanza dal bordo superiore
        AnchorPane.setLeftAnchor(vbox, 50.0); // Distanza dal bordo sinistro
        AnchorPane.setRightAnchor(vbox, 50.0); // Distanza dal bordo destro
        AnchorPane.setBottomAnchor(vbox, 50.0); // Distanza dal bordo inferiore

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(anchorPane);
        scrollPane.setFitToWidth(true);

        Button backButton = new Button("Torna alla tua scheda");
        backButton.setOnAction(event -> {
            MasterView masterView = MasterView.getInstance();
            masterView.showSchedaPersonaleView();
        });

        vbox.getChildren().addAll(backButton);

        //Scene scene = new Scene(scrollPane, 300, 200);
        Scene scene = new Scene(scrollPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}



