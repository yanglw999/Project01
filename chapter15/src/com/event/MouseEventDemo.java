package com.event;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MouseEventDemo extends Application {
    Text text = new Text(200,200,"hello, world."); // can be either in start() or out of start()

    @Override
    public void start(Stage primary){
        Pane pane = new Pane();
      //  Text text = new Text(200,200,"hello, world.");
        text.setFont(Font.font("carrier", FontWeight.BOLD, FontPosture.ITALIC,30));
        text.setFill(new Color(0.7,0.5,0.2,1));
        text.setUnderline(true);


        pane.getChildren().add(text);
        text.setOnMouseDragged(e ->{
            text.setX(e.getX());
            text.setY(e.getY());
        });
        Scene scene = new Scene(pane);
        primary.setScene(scene);
        primary.setTitle("MouseEvent Demo");
        primary.show();
    }
}
