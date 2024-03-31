package Exercise15;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise15_6 extends Application {
  static Text text = new Text();
  static boolean  flag = true;
    @Override
    public void start(Stage primaryStage){
        Pane pane = new Pane();
        pane.getChildren().add(text);
        text.setFill(Color.color(Math.random(),Math.random(),Math.random()));
        text.setFont(Font.font("carrier", FontWeight.BOLD, FontPosture.REGULAR,22));
        text.setX(300);
        text.setY(200);


        text.setText("Java is fun");
        text.setOnMouseClicked( e -> TextSwitch());
        text.setOnMouseDragged( e -> {
            text.setX(e.getX());
            text.setY(e.getY());
        });

        Scene scene = new Scene(pane,600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise15_6");
        primaryStage.show();

    }
    public static void TextSwitch(){
        if(flag){
            text.setText("Java is fun");
            flag = false;
        }else{
            text.setText("Java is powerful");
            flag = true;
        }
    }
}
