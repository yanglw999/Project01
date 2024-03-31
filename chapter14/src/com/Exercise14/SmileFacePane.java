package com.Exercise14;

import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class SmileFacePane extends Pane {
    public SmileFacePane (){
        // head
        Circle circle1 = new Circle(400,400,150);
        circle1.setStroke(Color.BLACK);
        circle1.setFill(Color.WHITE);
        // left eye
        Ellipse ellipse1 = new Ellipse(340,340,33,22);
        ellipse1.setStroke(Color.RED);
        ellipse1.setFill(Color.WHITE);
        Circle circle2 = new Circle(340,340,15);
        circle2.setStroke(Color.BLACK);
        circle2.setFill(Color.BLUE);
        // right eye
        Ellipse ellipse2 = new Ellipse(470,340,33,22);
        ellipse2.setStroke(Color.RED);
        ellipse2.setFill(Color.WHITE);
        Circle circle3 = new Circle(470,340,18);
        circle3.setStroke(Color.BLACK);
        circle3.setFill(Color.BLUE);
        // nose
        Polygon triangle = new Polygon();
        ObservableList<Double> list = triangle.getPoints();
        list.add(400.0);list.add(350.0);
        list.add(360.0);list.add(445.0);
        list.add(440.0);list.add(445.0);
        triangle.setFill(Color.WHITE);
        triangle.setStroke(Color.BLACK);
        // mouth
        Arc arc = new Arc(400,470,80,30,180,180);
        arc.setFill(Color.WHITE);
        arc.setType(ArcType.OPEN);
        arc.setStroke(Color.RED);
        arc.setStrokeWidth(5);
        getChildren().addAll(circle1,ellipse1,ellipse2,circle2,circle3,triangle,arc);

    }
}
