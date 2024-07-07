package com.example.progetto_ispw.view;

import javafx.stage.Stage;

public class MasterView {
    private Stage stage;
    private static MasterView instance;
    private MasterView(Stage stage) {
        this.stage = stage;
    }

    public static MasterView getInstance(Stage stage) {
        if(instance==null) {
            instance = new MasterView(stage);
        }
        return instance;
    }
    public void showLoginView() {
        LoginUserView luv = new LoginUserView();
        try {
            luv.start(this.stage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void showInternalLoginView() {
        LoginInternalView liv = new LoginInternalView();
        try {
            liv.start(this.stage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void showGeneralLoginView() {
        GeneralLoginView glv = new GeneralLoginView();
        try {
            glv.start(this.stage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void showRegistrazioneUserView() {
        RegistrazioneUserView ruv = new RegistrazioneUserView();
        try {
            ruv.start(this.stage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void showSchedaPersonaleView() {
        SchedaPersonaleView spv = new SchedaPersonaleView();
        try {
            spv.start(this.stage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void showHomePageView() {
        HomePageView hpv = new HomePageView();
        try {
            hpv.start(this.stage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void showQuestionarioView() {
        QuestionarioView qv = new QuestionarioView();
        try {
            qv.start(this.stage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
