package Exercise15;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Exercise15_7 extends Application {
    @Override
    public void start(Stage primaryStage){
        Circle circle = new Circle(200,300,60);
        circle.setStroke(Color.GREEN);
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(circle);

        circle.setOnMousePressed( e -> circle.setFill(Color.BLACK));
        circle.setOnMouseReleased( e -> circle.setFill(Color.WHITE));

        Scene scene = new Scene(stackPane,600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise15_7");
        primaryStage.show();

    }
}
