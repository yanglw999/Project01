package com.Exercise14;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class Cube extends Pane {
    // a cube is created by two rectangles and four lines
    public Cube(){
      double paneWidth = 200;
      double paneHeight = 200;

      double width = paneWidth * .9 - 30;
      double height = paneHeight * .9 - 60;
      double diff = Math.min(width,height) * .4;
      // back
        Rectangle r1 = new Rectangle(30, 60 - diff, width,height);
        r1.setFill(new Color(1,1,1,0));
        r1.setStroke(Color.BLACK);
        //r1.widthProperty().bind(widthProperty().subtract(10));
        //r1.heightProperty().bind(heightProperty().subtract(10+diff));
        // front
        Rectangle r2 = new Rectangle(10, 60, width,height);
        r2.setFill(new Color(1,1,1,0));
        r2.setStroke(Color.BLACK);
        //r2.widthProperty().bind(widthProperty().subtract(30));
        //r2.heightProperty().bind(heightProperty().subtract(60-diff));
        // four lines
        Line line1 = new Line(30,60-diff,10,60);
        line1.setStroke(Color.BLACK);
        Line line2 = new Line(30,60-diff+height,10,60+height);
        line1.setStroke(Color.BLACK);
        Line line3 = new Line(10+width,60+height,30+width,60-diff+height);
        line1.setStroke(Color.BLACK);
        Line line4 = new Line(10+width,60,30+width,60-diff);
        line1.setStroke(Color.BLACK);

        getChildren().addAll(r1,r2,line1,line2,line3,line4);

    }
}
