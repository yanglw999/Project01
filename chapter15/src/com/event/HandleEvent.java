package com.event;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HandleEvent extends Application {
    @Override
    public void start(Stage primary){
        HBox pane = new HBox(10);
        pane.setAlignment(Pos.CENTER);
        javafx.scene.control.Button ok = new javafx.scene.control.Button("OK");
        OkHandlerClass okHandlerClass = new OkHandlerClass();
        ok.setOnAction( e -> System.out.println( "another method click ok"));


        javafx.scene.control.Button cancel = new Button("Cancel");
        CancelHandlerClass cancelHandlerClass = new CancelHandlerClass();
        cancel.setOnAction(cancelHandlerClass);
        pane.getChildren().addAll(ok, cancel);

        Scene scene = new Scene(pane);
        primary.setScene(scene);
        primary.setTitle("HandleEvent");
        primary.show();

    }
}
class OkHandlerClass implements EventHandler<ActionEvent>{
    @Override
    public void handle(ActionEvent e){
        System.out.println("OK button clicked");
    }
}
class CancelHandlerClass implements EventHandler<ActionEvent>{
    @Override
    public void handle(ActionEvent e){
        System.out.println("Cancel button clicked");
    }
}
