package com.example.progetto_ispw;

import com.example.progetto_ispw.view.MasterView;
import javafx.application.Application;
import javafx.stage.Stage;

public class main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        MasterView masterView = MasterView.getInstance(stage);
        masterView.showGeneralLoginView();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
