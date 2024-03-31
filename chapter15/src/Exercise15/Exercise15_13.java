package Exercise15;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise15_13 extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Rectangle rectangle = new Rectangle(100,60,100,40);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.RED);
        pane.getChildren().add(rectangle);

        Text text = new Text();

        pane.setOnMouseMoved( e -> {
            text.setX(e.getX());
            text.setY(e.getY());
            if(rectangle.contains(e.getX(),e.getY())){
               text.setText("mouse point is inside the rectangle");
            }else {
                text.setText("mouse point is outside the rectangle");
            }

        });
        pane.getChildren().add(text);

        Scene scene = new Scene(pane, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise15_13");
        primaryStage.show();

        pane.requestFocus();
    }
}
