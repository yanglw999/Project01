package Exercise15;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Exercise15_15 extends Application {
    Circle c;
    @Override
    public void start(Stage primaryStage){
        Pane pane = new Pane();
        pane.setOnMousePressed(e -> {
            if(e.getButton() == MouseButton.PRIMARY){
                 c = new Circle(e.getX(),e.getY(),5);
                 c.setStroke( Color.color(Math.random(),Math.random(),Math.random(),Math.random()));
                pane.getChildren().add(c);
            }

        });
        // remove the nodes in pane
        pane.setOnMouseClicked(e ->{
            if(e.getButton() == MouseButton.SECONDARY){
                ObservableList<Node> list = pane.getChildren();
                for(int i = 0; i < list.size(); i++) {
                    if (list.get(i).contains(e.getX(), e.getY())) {
                        list.remove(i);
                    }
                }
            }
        });

        Scene scene = new Scene(pane, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise15_15");
        primaryStage.show();
    }
}
