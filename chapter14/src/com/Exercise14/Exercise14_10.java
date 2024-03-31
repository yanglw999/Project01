package com.Exercise14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Exercise14_10 extends Application {
    @Override
    public void start(Stage primaryStage){
        Pane pane = new Pane();
        // ellipse
        Ellipse ellipse = new Ellipse(200,80,50,30);
        ellipse.setFill(Color.WHITE);
        ellipse.setStroke(Color.BLACK);
        // two lines
        Line line1 = new Line(150,80,150,280);
        line1.setStroke(Color.RED);
        Line line2 = new Line(250,80,250,280);
        line1.setStroke(Color.RED);
        // arc
        Arc arc1 = new Arc(200,280,50,30,180,180);
        arc1.setType(ArcType.OPEN);
        arc1.setStroke(Color.GREEN);
        arc1.setFill(Color.WHITE); // setFill is necessary, otherwise it will be black
        pane.getChildren().addAll(ellipse,line1,line2,arc1);
        for(int i = 0; i < 6; i++){
            Arc arc2 = new Arc(200,280,50,30,i * 180 / 6,20);
            arc2.setType(ArcType.OPEN);
            arc2.setStroke(Color.GREEN);
            pane.getChildren().add(arc2);
        }
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise14_10");
        primaryStage.show();
    }
}
