package com.ui;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise16_18 extends Application {
    FanZoom fanZoom = new FanZoom();
    @Override
    public void start(Stage primaryStage){
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(5,5,5,20));
        Pane pane = new Pane();
        pane.getChildren().add(fanZoom);
        borderPane.setCenter(pane);
        pane.widthProperty().addListener(ov ->fanZoom.setW(pane.getWidth()));
        pane.heightProperty().addListener( ov -> fanZoom.setH(pane.getHeight()));

        Button pause = new Button("pause");
        Button resume = new Button("resume");
        Button reverse = new Button("reverse");

        HBox hBox = new HBox(20);
        hBox.getChildren().addAll(pause,resume,reverse);
        hBox.setPadding(new Insets(5));
        hBox.setAlignment(Pos.CENTER);
        borderPane.setTop(hBox);
        ScrollBar scrollBar = new ScrollBar();
        borderPane.setBottom(scrollBar);

        EventHandler<ActionEvent> eventHandler = e ->{
            fanZoom.spin();
        };
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(100),eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        pause.setOnAction(e -> animation.pause());
        resume.setOnAction(e -> animation.play());
        reverse.setOnAction( e -> fanZoom.reverse());
        scrollBar.valueProperty().addListener(ov ->fanZoom.setSpeedUnit(scrollBar.getValue()));

        Scene scene = new Scene(borderPane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise16_18");
        primaryStage.show();
    }
}
