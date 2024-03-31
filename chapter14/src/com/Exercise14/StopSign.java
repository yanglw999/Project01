package com.Exercise14;

import javafx.collections.ObservableList;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class StopSign extends StackPane {
    public StopSign(){
        double paneWith = getWidth();
        double paneHeight = getHeight();
        double centerX = paneWith / 2;
        double centerY = paneHeight / 2;
        double radius = 200;
        Polygon polygon = new Polygon();
        polygon.setStroke(Color.BLACK);
        polygon.setFill(new Color(1,0,0,1));
        ObservableList<Double> list = polygon.getPoints();
        // Math.sin(cos) needs to use 2*Math.PI to replace 360 degree
        for(int i = 0; i < 8; i++){
            list.add(centerX + radius * Math.cos(2 * Math.PI /16 + 2 * Math.PI / 8 * i));//x
            list.add(centerY - radius * Math.sin(2 * Math.PI /16 + 2 * Math.PI / 8 * i));//y  2 * Math.PI / 6
        }
        Text text = new Text("STOP");
        text.setFill(Color.WHITE);
        text.setFont(Font.font("Arial", FontWeight.BOLD,FontPosture.REGULAR,100.0));
        getChildren().addAll(polygon,text);
    }
}
