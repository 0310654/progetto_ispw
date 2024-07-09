package com.example.progetto_ispw.view;

import com.example.progetto_ispw.controller.MasterController;
import com.example.progetto_ispw.model.Questionario;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public class CollabsView extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Storico Questionari");

        ArrayList<Pair> collabs = MasterController.getInstance().getCollabs();

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20, 20, 20, 20));

        Questionario q;
        String r;

        for (Pair collab : collabs) {
            q = (Questionario) collab.getKey();
            r = (String) collab.getValue();
            vbox.getChildren().addAll(new Label(q.getDomanda()), new Label(r));
        }

        Button backButton = new Button("Torna alla home page");
        backButton.setOnAction(event -> {
            MasterView masterView = MasterView.getInstance();
            masterView.showHomePageView();
        });

        Scene scene = new Scene(vbox, 300, 200);
        stage.setScene(scene);
        stage.show();

    }
}
