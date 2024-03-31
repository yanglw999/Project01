package Exercise15;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Exercise15_2 extends Application {

    @Override
    public void start(Stage primaryStage){
        BorderPane borderPane = new BorderPane();
        RectanglePane rectanglePane =  new RectanglePane();

        borderPane.setCenter(rectanglePane);
        Button button = new Button("right rotate");
        VBox vBox = new VBox(20);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().add(button);
        borderPane.setBottom(vBox);

        button.setOnAction(e -> {
           rectanglePane.spin();
            });

        Scene scene = new Scene(borderPane,1000,800);
        primaryStage.setTitle("Exercise15_2");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
class RectanglePane extends Pane {
    double h = 800;
    double w = 1000;
    double radius = Math.min(h,w) * 0.1 * 0.5;
    double width = w * 0.05;
    double height = h * .1;
    double centerX = w / 2.0;
    double centerY = h /2.0;
    double degree = 2 * Math.PI / 24;
    double count = 0;
    double vX = centerX + radius * Math.cos(degree);
    double vY = centerY - radius * Math.sin(degree);
    Rectangle rectangle = new Rectangle(vX,vY,width,height);

    public RectanglePane(){

        getChildren().add(rectangle);
        rectangle.setStrokeWidth(1);
        rectangle.setStroke(Color.RED);
        rectangle.setFill(Color.WHITE);
    }
    public RectanglePane( double w, double h){
        this();
        this.w = w;
        this.h = h;
    }
    public void spin(){
        setDegree(getDegree() - (2 * Math.PI / 24) );
        this.vX = centerX + radius * Math.cos(degree);
        this.vY = centerY - radius * Math.sin(degree);
        rectangle.setX(vX);
        rectangle.setY(vY);

    }
    public void setDegree(double degree) {
        this.degree = degree;
    }
    public double getDegree() {
        return degree;
    }
}
