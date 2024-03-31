package com.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Exercise16_8 extends Application {

    @Override
    public void start(Stage primaryStage){
        Circle c1 = new Circle();
        c1.setStroke(Color.BLACK);
        c1.setFill(Color.color(1,1,1,0));


        Circle c2 = new Circle();
        c2.setStroke(Color.BLACK);
        c2.setFill(new Color(1,1,1,0));
        Pane pane = new Pane();
        pane.getChildren().addAll(c1,c2);

        BorderPane bP = new BorderPane();
        bP.setPadding(new Insets(5));
        bP.setCenter(pane);

        Label question = new Label("Two circles intersect? ");
        TextField tFSignal = new TextField();
        HBox hBoxTop = new HBox(5);
        hBoxTop.setAlignment(Pos.CENTER);
        hBoxTop.getChildren().addAll(question,tFSignal);
        bP.setTop(hBoxTop);

        TextField tFX1 = new TextField();
        TextField tFX2 = new TextField();
        TextField tFY1 = new TextField();
        TextField tFY2 = new TextField();
        TextField r1 = new TextField();
        TextField r2 = new TextField();

        // circle 1 info
        GridPane gridPane1 = new GridPane();
        gridPane1.setHgap(5);
        gridPane1.setVgap(5);
        gridPane1.add(new Label("Enter Circle 1 info:"), 0,0);
        gridPane1.add(new Label("Center x:"), 0,1);
        gridPane1.add(new Label("Center y:"),0,2);
        gridPane1.add(new Label("Radius:"), 0,3);

        gridPane1.add(tFX1,1,1);
        gridPane1.add(tFY1,1,2);
        gridPane1.add(r1,1,3);
        // circle2 info
        GridPane gridPane2 = new GridPane();
        gridPane2.setHgap(5);
        gridPane2.setVgap(5);
        gridPane2.add(new Label("Enter Circle 2 info:"), 0,0);
        gridPane2.add(new Label("Center x:"), 0,1);
        gridPane2.add(new Label("Center y:"),0,2);
        gridPane2.add(new Label("Radius:"), 0,3);

        gridPane2.add(tFX2,1,1);
        gridPane2.add(tFY2,1,2);
        gridPane2.add(r2,1,3);

        HBox hBox1 = new HBox(30);
        hBox1.setAlignment(Pos.CENTER);
        hBox1.getChildren().addAll(gridPane1,gridPane2);


        Button button = new Button("Redraw circles");
        HBox hBox2 = new HBox(20);
        hBox2.getChildren().add(button);
        hBox2.setAlignment(Pos.CENTER);

        VBox vBox = new VBox(5);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(hBox1,hBox2);
        bP.setBottom(vBox);

        button.setOnAction(e ->{
            Double x1 = Double.parseDouble(tFX1.getText());
            Double y1 = Double.parseDouble(tFY1.getText());
            Double circleR1 = Double.parseDouble(r1.getText());
            c1.setCenterX(x1);
            c1.setCenterY(y1);
            c1.setRadius(circleR1);

            Double x2 = Double.parseDouble(tFX2.getText());
            Double y2 = Double.parseDouble(tFY2.getText());
            Double circleR2 = Double.parseDouble(r2.getText());
            c2.setCenterX(x2);
            c2.setCenterY(y2);
            c2.setRadius(circleR2);
        });

        c1.setOnMouseDragged( e ->{
            c1.setCenterX(e.getX());
            c1.setCenterY(e.getY());
            tFX1.setText("" + e.getX());
            tFY1.setText(String.valueOf(e.getY()));
            if(Math.abs(new Point2D(c1.getCenterX(),c1.getCenterY()).distance(new Point2D(c2.getCenterX(),c2.getCenterY()))) <
                    (c1.getRadius() + c2.getRadius())){
                tFSignal.setText( "Yes");
            }else{
                tFSignal.setText("No");
            }
        });
        c2.setOnMouseDragged( e ->{
            c2.setCenterX(e.getX());
            c2.setCenterY(e.getY());
            tFX2.setText("" + e.getX());
            tFY2.setText(String.valueOf(e.getY()));
            if(Math.abs(new Point2D(c1.getCenterX(),c1.getCenterY()).distance(new Point2D(c2.getCenterX(),c2.getCenterY()))) <
                    (c1.getRadius() + c2.getRadius())){
                tFSignal.setText( "Yes");
            }else{
                tFSignal.setText("No");
            }
        });

        Scene scene = new Scene(bP,800,600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise16_8");
        primaryStage.show();


    }
}
