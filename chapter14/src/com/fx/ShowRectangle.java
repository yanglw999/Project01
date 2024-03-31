package com.fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ShowRectangle extends Application {
    @Override
    public void start(Stage primary) {
        Pane pane = new Pane();
        Rectangle rectangle1 = new Rectangle(25, 10, 60, 30);
        rectangle1.setStroke(Color.BLACK);
        rectangle1.setFill(Color.WHITE);
        pane.getChildren().add(new Text(10, 27, "r1"));
        pane.getChildren().add(rectangle1);

        Rectangle rectangle2 = new Rectangle(25, 50, 60, 30);
        //rectangle2.set;
        pane.getChildren().add(new Text(10, 67, "r2"));
        pane.getChildren().add(rectangle2);

        Rectangle rectangle3 = new Rectangle(25, 90, 60, 30);
        rectangle3.setArcWidth(15);
        rectangle3.setArcHeight(25);
        pane.getChildren().add(new Text(10, 107, "r3"));
        pane.getChildren().add(rectangle3);

        for (int i = 0; i < 4; i++) {
            Rectangle rectangle4 = new Rectangle(105, 50, 100, 30);
            rectangle4.setRotate(i * 360 / 8);//
            rectangle4.setStroke(Color.color(Math.random(), Math.random(), Math.random()));
            rectangle4.setFill(Color.color(Math.random(), Math.random(), Math.random()));
            pane.getChildren().add(rectangle4);
        }
            Scene scene = new Scene(pane, 250, 150);
            primary.setTitle("Show Rectangle");
            primary.setScene(scene);
            primary.show();


    }
    public static void main(String[] args) {
        Application.launch();
    }
}
