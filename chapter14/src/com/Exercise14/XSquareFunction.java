package com.Exercise14;

import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;

public class XSquareFunction extends Pane {
    public XSquareFunction(){
        // horizontal line and vertical line
        Line xAxis = new javafx.scene.shape.Line(10,10,10,10);
        Line yAxis = new javafx.scene.shape.Line(10,10,10,10);
        xAxis.endXProperty().bind(widthProperty().subtract(10));
        xAxis.startYProperty().bind(heightProperty().divide(2));
        xAxis.endYProperty().bind(heightProperty().divide(2));

        yAxis.startXProperty().bind(widthProperty().divide(2));
        yAxis.endXProperty().bind(widthProperty().divide(2));
        yAxis.endYProperty().bind(heightProperty().subtract(10));

        Label labelX = new Label("x"); //.layout()
        labelX.setStyle("-fx-font-size: 15;-fx-fill: GREEN");
        labelX.layoutXProperty().bind(widthProperty().subtract(10));
        labelX.layoutYProperty().bind(heightProperty().divide(2).subtract(30));

        Text textY = new Text("Y");
        textY.xProperty().bind(widthProperty().divide(2).add(20));
        textY.setY(10);
        // the arrow in x-axis
        Polyline polylineX = new Polyline();
        ObservableList<Double> listX = polylineX.getPoints();
        polylineX.layoutYProperty().bind(heightProperty().divide(2));
        polylineX.layoutXProperty().bind(widthProperty().subtract(10).subtract(10));
        // points need to be posed in order  xAxis.getEndY()
        listX.add( 0.0 );   listX.add(  xAxis.getEndY() - 6.0);
        listX.add( 10.0 );       listX.add( xAxis.getEndY());
        listX.add( 0.0 );   listX.add( xAxis.getEndY() + 6.0);
        // the arrow in y-axis
        Polyline polylineY = new Polyline();
        ObservableList<Double> listY = polylineY.getPoints();
        polylineY.layoutXProperty().bind(widthProperty().divide(2));
        listY.add( yAxis.getStartX() - 6.0);   listY.add( 10.0 + 10.0);
        listY.add(yAxis.getStartX());         listY.add( 10.0);
        listY.add(yAxis.getStartX() + 6.0);    listY.add( 20.0);
        // original point
        Label label0 = new Label("0"); //.layout()
        label0.setStyle("-fx-font-size: 20;-fx-font-weight: bold");
        label0.layoutXProperty().bind(widthProperty().divide(2).add(10));
        label0.layoutYProperty().bind(heightProperty().divide(2).add(10));

        // f(x) = x^2
        Polyline polylineXSquare = new Polyline();
        ObservableList<Double> listOfPoints = polylineXSquare.getPoints();
        polylineXSquare.layoutXProperty().bind(widthProperty().divide(2));
        polylineXSquare.layoutYProperty().bind(heightProperty().divide(2));
        double k = 0.01;
        for(double i = -180; i <= 180; i++){
            listOfPoints.add(i);
            listOfPoints.add((k * i * i) - (2 * k * i * i));
        }



        getChildren().addAll(xAxis,yAxis,polylineX,polylineY,labelX,textY,label0, polylineXSquare);
    }
}
