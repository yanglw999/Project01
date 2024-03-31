package com.event;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TimeLineDemo extends Application {
    @Override
    public void start(Stage primary){
        StackPane pane = new StackPane(); //StackPane, text is positioned in the center
        // Pane pane = new Pane();        // Pane, text is positioned in the left top
        Text text = new Text(50,50, "Life is short.");
        text.setStyle("-fx-fill: red; -fx-background-color: yellow");
        text.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC,20));
        pane.getChildren().add(text);

        EventHandler<ActionEvent> eventHandler = e -> {
            if(text.getText().length() != 0){
                text.setText("");
            }else{
                text.setText("life is short, so enjoy.");
            }
        };
        // Timeline is like a loop, which repeatedly carrys out moveBall()
                                             // new KeyFrame()
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), eventHandler));// e-> eventHandler
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        text.setOnMouseClicked(e ->{
            if(timeline.getStatus() == Animation.Status.STOPPED){
                timeline.play();
            }else{
                timeline.stop();
            }
        });

        Scene scene = new Scene(pane);
        primary.setTitle("TimeLine Demo");
        primary.setScene(scene);
        primary.show();


    }
}
