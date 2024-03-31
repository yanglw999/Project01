package Exercise15;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;

public class Exercise15_17B extends Application {
    @Override
    public void start(Stage primaryStage){
        Pane pane = new Pane();
        double radius = 10;
        Rectangle rectangle = new Rectangle();
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.RED);
        pane.getChildren().add(rectangle);

        pane.setOnMouseClicked( e -> {
            if(e.getButton() == MouseButton.PRIMARY){
                Circle circle = new Circle(e.getX(),e.getY(),radius);
                circle.setFill(Color.color(Math.random(), Math.random(),Math.random(),Math.random()));
                pane.getChildren().add(circle);
            } else if(e.getButton() == MouseButton.SECONDARY){
                ObservableList<Node> list = pane.getChildren();
                for(int i = 0 ; i < list.size(); i++){
                    if(list.get(i) instanceof Circle && list.get(i).contains(e.getX(),e.getY())){
                        list.remove(i);
                    }
                }
            }
            ArrayList<Double> xList = new ArrayList<>();
            ArrayList<Double> yList = new ArrayList<>();
            for(Node node : pane.getChildren()){
                if(node instanceof Circle ){
                    xList.add(((Circle) node).getCenterX());
                    yList.add(((Circle) node).getCenterY());
                }
            }
            double minX = Collections.min(xList);
            double maxX = Collections.max(xList);
            double minY = Collections.min(yList);
            double maxY = Collections.max(yList);

            rectangle.setX(minX - radius);
            rectangle.setY(minY - radius);
            rectangle.setWidth(maxX - minX + ( 2 * radius));
            rectangle.setHeight(maxY - minY + (2 * radius));

        });
        Scene scene = new Scene(pane,800,600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise15_17B");
        primaryStage.show();
    }
}
