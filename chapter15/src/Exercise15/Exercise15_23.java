package Exercise15;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise15_23 extends Application {
    StopSign stopSign = new StopSign();
    @Override
    public void start(Stage primaryStage){
        Pane pane = new Pane();

        pane.getChildren().add(stopSign);

        Scene scene = new Scene(pane,800,600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise15_23");
        primaryStage.show();

        scene.widthProperty().addListener( ov ->{
            stopSign.paneWith = pane.getWidth();
            setValues();
        });
        scene.heightProperty().addListener( ov ->{
            stopSign.paneHeight = pane.getHeight();
            setValues();
        });
    }
    private void setValues(){
        stopSign.centerX = stopSign.paneWith / 2;
        stopSign.centerY = stopSign.paneHeight /2;
    }
}
 class StopSign extends Pane {
     double paneWith = 800;
     double paneHeight = 600;
     double centerX = paneWith / 2;
     double centerY = paneHeight / 2;
     double radius = 200;
     Polygon polygon = new Polygon();

     ObservableList<Double> list = polygon.getPoints();

     Text text = new Text("STOP");
    public StopSign(){
        // Math.sin(cos) needs to use 2*Math.PI to replace 360 degree
        for(int i = 0; i < 8; i++){
            list.add(centerX + radius * Math.cos(2 * Math.PI /16 + 2 * Math.PI / 8 * i));//x
            list.add(centerY - radius * Math.sin(2 * Math.PI /16 + 2 * Math.PI / 8 * i));//y  2 * Math.PI / 6
        }
        polygon.setStroke(Color.BLACK);
        polygon.setFill(new Color(1,0,0,1));

        text.setX(270);
        text.setY(330);
        text.setFill(Color.WHITE);
        text.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,100.0));
        getChildren().addAll(polygon,text);
    }
}

