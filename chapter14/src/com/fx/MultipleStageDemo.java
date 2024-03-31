package com.fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MultipleStageDemo extends Application {
    @Override
    public void start(Stage st1){
        //Stage st1 = new Stage();//primaryStage has been created by JVM, do not need to re-created
        Button b1 = new Button("OK");
        Scene sc1 = new Scene(b1,200,250);
        st1.setTitle("Stage 1");
        st1.setScene(sc1);
        st1.show();
        // second stage needs to be created on our own
        Stage st2 = new Stage();
        Scene sc2 = new Scene(new javafx.scene.control.Button("ON"), 100, 150);
        st2.setTitle("Stage 2");
        st2.setScene(sc2);
        st2.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
