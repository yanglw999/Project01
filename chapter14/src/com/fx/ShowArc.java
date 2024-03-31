package com.fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ShowArc extends Application {
    @Override
    public void start(Stage primary){
        Pane pane = new Pane();
        Arc arc1 = new Arc(150,100,80,80,30,35);
        arc1.centerXProperty().bind(pane.widthProperty().divide(2));
        arc1.centerYProperty().bind(pane.heightProperty().divide(2));
        arc1.setType(ArcType.ROUND);
        arc1.setFill(Color.GREEN);
        pane.getChildren().add(new Text(210,40,"arc1: round"));
        pane.getChildren().add(arc1);

        Arc arc2 = new Arc(150,100,80,80,30 +90,35);
        arc2.centerXProperty().bind(pane.widthProperty().divide(2));
        arc2.centerYProperty().bind(pane.heightProperty().divide(2));
        arc2.setFill(Color.YELLOW);
        arc2.setType(ArcType.CHORD);
       // Text text1 = new Text(20,40,"arc2: chord");
        //text1.xProperty().bind(pane.widthProperty()/);
        pane.getChildren().add(new Text(20,40,"arc2: chord"));
        pane.getChildren().add(arc2);

        Arc arc3 = new Arc(150,100,80,80,30+180,35);
        arc3.centerXProperty().bind(pane.widthProperty().divide(2));
        arc3.centerYProperty().bind(pane.heightProperty().divide(2));
        arc3.setType(ArcType.OPEN);
        arc3.setFill(Color.color(Math.random(),Math.random(),Math.random()));
        pane.getChildren().add(new Text(20,40+130,"arc3: open"));
        pane.getChildren().add(arc3);

        Arc arc4 = new Arc(150,100,80,80,30+270,35);
        arc4.centerXProperty().bind(pane.widthProperty().divide(2));
        arc4.centerYProperty().bind(pane.heightProperty().divide(2));
        arc4.setFill(Color.color(Math.random(),Math.random(),Math.random()));
        arc4.setType(ArcType.CHORD);
        pane.getChildren().add(new Text(210,40+130,"arc4: chord"));
        pane.getChildren().add(arc4);

        Scene scene = new Scene(pane);
        primary.setScene(scene);
        primary.setTitle("Show Arc");
        primary.show();
    }

    public static void main(String[] args) {
        Application.launch();
    }
}
