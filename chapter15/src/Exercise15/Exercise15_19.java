package Exercise15;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;



public class Exercise15_19 extends Application {
    int count = 0;
    @Override
    public void start(Stage primaryStage){
        double radius = 10;
        Pane pane = new Pane();
        // the initial circle position can be fixed
        Circle circle = new Circle(new Random().nextInt(500),new Random().nextInt(500), radius);
        circle.setFill(Color.color(Math.random(),Math.random(),Math.random(),Math.random()));
        Text text = new Text();
        pane.getChildren().add(text);
        pane.getChildren().add(circle);
        long t0 = System.currentTimeMillis();

            circle.setOnMouseClicked(e -> {
                // replace loop
               if (circle.contains(e.getX(),e.getY())) {
                   count++;

                   if(count == 5){
                        pane.getChildren().remove(circle);
                       long t1 = System.currentTimeMillis();
                       long period = t1 - t0;
                       text.setText("Time spent is " + period + " milliseconds");
                       text.setX(new Random().nextInt((int) pane.getWidth()));
                       text.setY(new Random().nextInt((int) pane.getHeight()));
                        return;
                   }

                      }
                circle.setCenterX(new Random().nextInt((int) pane.getWidth()));
                circle.setCenterY(new Random().nextInt((int) pane.getHeight()));
                circle.setFill(Color.color(Math.random(), Math.random(), Math.random(), Math.random()));
            });

        Scene scene = new Scene(pane,800,600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise15_17B");
        primaryStage.show();
    }
}
