package com.fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class ShowLine extends Application {
    @Override
    public void start(Stage primary){
        Scene scene = new Scene(new LinePane());
        primary.show();
        primary.setTitle("ShowLine");
        primary.setScene(scene);

    }
}
class LinePane extends Pane{
    public LinePane(){
        Line line1 = new Line(10,10,10,10);
        line1.endXProperty().bind(widthProperty().subtract(10));// covering endX--> (screen width - 10)
        //also can change to .startXProperty() & .startYProperty()
        line1.endYProperty().bind(heightProperty().subtract(10));// covering endY-->(screen height - 10)
        line1.setStrokeWidth(5);
        line1.setStroke(Color.GREEN);
        getChildren().add(line1);

        Line line2 = new Line(10,10,10,10);
        line2.startXProperty().bind(widthProperty().subtract(10));
        line2.endYProperty().bind(heightProperty().subtract(10));
        line2.setStroke(Color.RED);
        line2.setStrokeWidth(20);
        getChildren().add(line2);

        Line line3 = new Line(30,30,30,30);
        line3.startYProperty().bind(heightProperty().subtract(30));
        line3.endXProperty().bind(widthProperty().subtract(30));
        line3.setStroke(Color.YELLOW);
        line3.setStrokeWidth(5);
        getChildren().add(line3);
    }
}
