package com.example.progetto_ispw.view;/*package com.example.progetto_ispw.view;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ClassView {

    private Scanner scanner;

    public ClassView(){
        this.scanner = new Scanner(System.in);
    }

    public Scanner getScanner(){
        return this.scanner;
    }

    public String getInput(String prompt) {
        System.out.println(prompt);
        String userinput = scanner.nextLine();
        System.out.println("hai inserito: " + userinput);
        return userinput;
    }

    public void printResultSet(ResultSet rs, String descrizione) {

        System.out.println("-------------------");
        System.out.println(descrizione);
        System.out.println("-------------------");
        try {
            int numero_colonne = rs.getMetaData().getColumnCount();
            for (int i = 1; i<=numero_colonne; i++){
                System.out.print(rs.getMetaData().getColumnName(i) + " | ");
            }
            System.out.println();
            while(rs.next()) {
                for (int i = 1; i<=numero_colonne; i++) {
                    System.out.print(rs.getString(i) + " | ");
                }
                System.out.println();

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("-------------------");
    }

}*/


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import static javafx.application.Application.launch;

public class ClassView  {

    private TextArea outputArea;
    private Stage primaryStage;

    public void start() {
        primaryStage.setTitle("ClassView");

        // Creazione dei campi di input
        Label inputLabel = new Label("Inserisci un input:");
        TextField inputField = new TextField();
        Button submitButton = new Button("Invia");
        outputArea = new TextArea();
        outputArea.setEditable(false);

        // Layout
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));
        vbox.getChildren().addAll(inputLabel, inputField, submitButton, outputArea);

        // Gestore dell'evento del bottone di invio
        submitButton.setOnAction(event -> {
            String userInput = inputField.getText();
            outputArea.appendText("Hai inserito: " + userInput + "\n");
            inputField.clear();
        });

        // Scena
        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Metodo per visualizzare il ResultSet
    public void printResultSet(ResultSet rs, String descrizione) {
        StringBuilder sb = new StringBuilder();
        sb.append("-------------------\n");
        sb.append(descrizione).append("\n");
        sb.append("-------------------\n");
        try {
            ResultSetMetaData metaData = rs.getMetaData();
            int numero_colonne = metaData.getColumnCount();
            for (int i = 1; i <= numero_colonne; i++) {
                sb.append(metaData.getColumnName(i)).append(" | ");
            }
            sb.append("\n");
            while (rs.next()) {
                for (int i = 1; i <= numero_colonne; i++) {
                    sb.append(rs.getString(i)).append(" | ");
                }
                sb.append("\n");
            }
        } catch (SQLException e) {
            sb.append("Errore: ").append(e.getMessage());
        }
        sb.append("-------------------\n");
        outputArea.appendText(sb.toString());
    }

    public static void main(String[] args) {
        launch(args);
    }
}

