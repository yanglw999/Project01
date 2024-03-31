package com.ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Exercise16_2 extends Application {
    @Override
    public void start(Stage primaryStage){
        StackPane ShapePane = new StackPane();
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10));
        borderPane.setCenter(ShapePane);

        HBox hBox = new HBox(10);
        ToggleGroup tg = new ToggleGroup();
        RadioButton btCircle = new RadioButton("Circle");
        RadioButton btRectangle = new RadioButton("Rectangle");
        RadioButton btEllipse = new RadioButton("Ellipse");

        btCircle.setToggleGroup(tg);
        btRectangle.setToggleGroup(tg);
        btEllipse.setToggleGroup(tg);

        CheckBox chk = new CheckBox("Fill");
        hBox.getChildren().addAll(btCircle,btRectangle,btEllipse,chk);
        hBox.setAlignment(Pos.CENTER);
        borderPane.setBottom(hBox);

        Circle circle = new Circle(50);
        Rectangle rectangle = new Rectangle(100,200,200,100);
        Ellipse ellipse = new Ellipse(100,80);

        EventHandler<ActionEvent> eventHandler = e -> {
            if(btCircle.isSelected()){

                ShapePane.getChildren().clear();
                ShapePane.getChildren().add(circle);
            }else if(btRectangle.isSelected()){

                ShapePane.getChildren().clear();
                ShapePane.getChildren().add(rectangle);
            }else if(btEllipse.isSelected()){

                ShapePane.getChildren().clear();
                ShapePane.getChildren().add(ellipse);
            }else {
                ShapePane.getChildren().clear();
            }
        };
        btCircle.setOnAction(eventHandler);
        btRectangle.setOnAction(eventHandler);
        btEllipse.setOnAction(eventHandler);
        chk.setOnAction(e ->{
            if(btCircle.isSelected() && chk.isSelected()){
                    circle.setFill(Color.GREEN);
            }else if(btRectangle.isSelected() && chk.isSelected()){
                    rectangle.setFill(Color.GREEN);
            }else if(btEllipse.isSelected() && chk.isSelected()){
                    ellipse.setFill(Color.GREEN);
            }
        });

        Scene scene = new Scene(borderPane,800,600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise16_2");
        primaryStage.show();
    }
}
