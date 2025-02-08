package com.example.progetto_ispw.view;

import com.example.progetto_ispw.controller.MasterController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.cell.PropertyValueFactory;

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
        VBox vbox = new VBox(10); // Aggiungiamo spazio tra gli elementi
        for (AbstractMap.SimpleEntry<String, String> pair : collabs) {
            // Crea le etichette per ogni coppia domanda/risposta
            Label domandaLabel = new Label("Domanda : \"" + pair.getKey() + "\"");
            Label rispostaLabel = new Label("La tua risposta : \"" + pair.getValue() + "\"");
            vbox.getChildren().addAll(domandaLabel, rispostaLabel);
        }

        //Scene scene = new Scene(new Group());
        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    //private ObservableList<AbstractMap.SimpleEntry<String, String>> collabs = FXCollections.observableArrayList();

    /*public void start(Stage stage) throws Exception {
        primaryStage.setTitle("Storico Questionari");

        List<AbstractMap.SimpleEntry<String, String>>  collabs = MasterController.getInstance().getCollabs();

        // Crea la TableView
        TableView<AbstractMap.SimpleEntry<String, String>> tableView = new TableView<>();

        // Crea la colonna per la domanda
        TableColumn<AbstractMap.SimpleEntry<String, String>, String> domandaColumn = new TableColumn<>("Domanda");
        domandaColumn.setCellValueFactory(cellData ->
                javafx.beans.property.SimpleStringProperty(cellData.getValue().getKey())
        );

        // Crea la colonna per la risposta
        TableColumn<AbstractMap.SimpleEntry<String, String>, String> rispostaColumn = new TableColumn<>("Risposta");
        rispostaColumn.setCellValueFactory(cellData ->
                javafx.beans.property.SimpleStringProperty(cellData.getValue().getValue())
        );

        // Aggiungi le colonne alla tabella
        tableView.getColumns().addAll(domandaColumn, rispostaColumn);

        // Imposta i dati sulla tabella
        tableView.setItems(data);

        // Aggiungi la TableView a un layout
        VBox vbox = new VBox(tableView);

        // Crea la scena e visualizzala
        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tabella Domande e Risposte");
        primaryStage.show();
    }





        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20, 20, 20, 20));



        Button backButton = new Button("Torna alla home page");
        backButton.setOnAction(event -> {
            MasterView masterView = MasterView.getInstance();
            masterView.showHomePageView();
        });

        Scene scene = new Scene(vbox, 300, 200);
        stage.setScene(scene);
        stage.show();

    }*/
}



