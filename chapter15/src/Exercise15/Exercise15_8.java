package Exercise15;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise15_8 extends Application {

    @Override
    public void start(Stage primaryStage){
        Text text = new Text();
        Pane pane = new Pane();
        pane.getChildren().add(text);

        // pane.setOnMouseClicked();
        pane.setOnMouseClicked( e -> {
            text.setX(e.getX());
            text.setY(e.getY());
            text.setText("(" + String.format("%.2f",e.getX()) + ", " + String.format("%.2f",e.getY()) + ")");
        });

        Scene scene = new Scene(pane,600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise15_8");
        primaryStage.show();
    }
}
