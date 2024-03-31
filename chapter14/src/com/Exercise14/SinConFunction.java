package com.Exercise14;

import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;

public class SinConFunction extends Pane {
    public SinConFunction(){
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

        // sin
        Polyline polyline1 = new Polyline();
        polyline1.setStroke(Color.RED);
        ObservableList<Double> listOfPoints = polyline1.getPoints();
        polyline1.layoutXProperty().bind(widthProperty().divide(2));
        polyline1.layoutYProperty().bind(heightProperty().divide(2));

        for(double i = -4 * Math.PI; i <= 4 * Math.PI; i = i + Math.PI / 20){
            listOfPoints.add(i * 60);
            listOfPoints.add(-Math.sin(i) * 120);
        }
        // cos
        Polyline polyline2 = new Polyline();
        polyline2.setStroke(Color.GREEN);
        ObservableList<Double> listOfPoints2 = polyline2.getPoints();
        polyline2.layoutXProperty().bind(widthProperty().divide(2));
        polyline2.layoutYProperty().bind(heightProperty().divide(2));

        for(double i = -4 * Math.PI; i <= 4 * Math.PI; i = i + Math.PI / 20){
            listOfPoints2.add(i * 60);
            listOfPoints2.add(-Math.cos(i) * 120);
        }

        for(int i = -4; i <= 4; i++){
            Label labelPI;
            if(i == 0){
                labelPI = new Label();
            }else if(i == 1 || i == -1){
                if(i == -1){
                    labelPI = new Label("-π");
                }else {
                    labelPI = new Label("π");
                }

            }else  {
                labelPI = new Label( i + "π");
            }

            labelPI.layoutXProperty().bind(widthProperty().divide(8 ).multiply( i + 4));
            labelPI.layoutYProperty().bind(heightProperty().divide(2).add(5));
            getChildren().add(labelPI);
        }


        getChildren().addAll(xAxis,yAxis,polylineX,polylineY,labelX,textY,label0, polyline1,polyline2);
    }

}
