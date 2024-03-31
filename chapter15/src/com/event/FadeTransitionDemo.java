package com.event;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FadeTransitionDemo extends Application {
    @Override
    public void start(Stage primary){
        Pane pane = new Pane();
        Ellipse ellipse = new Ellipse(10, 10, 20, 15);
        ellipse.centerXProperty().bind(pane.widthProperty().divide(2));
        ellipse.centerYProperty().bind(pane.heightProperty().divide(2));
        ellipse.radiusXProperty().bind(pane.widthProperty().multiply(.4));
       // ellipse.radiusYProperty().bind(pane.heightProperty().multiply(.4));

        pane.heightProperty().addListener(ov ->ellipse.setRadiusY(pane.getHeight()*.4));//  bind()

        ellipse.setStroke(Color.BLACK);
        ellipse.setStyle("-fx-fill: green;");
        pane.getChildren().add(ellipse);

        FadeTransition ft = new FadeTransition(Duration.seconds(5),ellipse);
        ft.setFromValue(1.);
        ft.setToValue(0.1);
        ft.setByValue(.1);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();

        ellipse.setOnMousePressed(e -> ft.stop());
        ellipse.setOnMouseReleased(e -> ft.play());

        Scene scene = new Scene(pane);
        primary.setScene(scene);
        primary.setTitle("FadeTransition Demo");
        primary.show();
    }
}
