package Exercise15;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Exercise15_3 extends Application {
    @Override
    public void start(Stage primaryStage){
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(3,3,5,3));

        Button left = new Button("Left");
        Button right = new Button("Right");
        Button up = new Button("Up");
        Button down = new Button("Down");
        HBox hBox = new HBox(30);
        hBox.getChildren().addAll(left, right, up, down);
        hBox.setAlignment(Pos.CENTER);
        borderPane.setBottom(hBox);

        BallPane ballPane = new BallPane();
        borderPane.setCenter(ballPane);

        ballPane.setOnMouseDragged(e -> {
            ballPane.setCenterX(e.getX());
            ballPane.setCenterY(e.getY());
        });

        left.setOnAction(e ->ballPane.moveLeft());
        right.setOnAction(e -> ballPane.moveRight());
        up.setOnAction(e -> ballPane.moveUp());
        down.setOnAction(e -> ballPane.moveDown());

        Scene scene = new Scene(borderPane,700,500);
        primaryStage.setTitle("Exercise15_3");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
class BallPane extends Pane{

    Circle circle = new Circle(100,100,20);

    double step = 5;
    public BallPane(){
        getChildren().add(circle);
        circle.setFill(Color.RED);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(2);
    }
    public void moveRight(){
        if(getWidth() - (circle.getCenterX() + circle.getRadius()) >= step){
            circle.setCenterX(circle.getCenterX() + step);
        }else{
            circle.setCenterX(getWidth() - circle.getRadius());
        }
    }
    public void moveLeft(){
        if((circle.getCenterX() - circle.getRadius()) > step){
            circle.setCenterX(circle.getCenterX() - step);
        }else{circle.setCenterX(circle.getRadius());}
    }
    public void moveUp(){
        if((circle.getCenterY() - circle.getRadius()) > step){
            circle.setCenterY(circle.getCenterY() - step);
        }else{
            circle.setCenterY(circle.getRadius());
        }
    }
    public void moveDown(){
        if((getHeight() - (circle.getCenterY() + circle.getRadius()) > step)){
            circle.setCenterY(circle.getCenterY() + circle.getRadius());
        }else {
            circle.setCenterY(getHeight() - circle.getRadius());
        }
    }

    public void setCenterX(double centerX) {
         circle.setCenterX(centerX);
    }

    public void setCenterY(double centerY) {
        circle.setCenterY(centerY);
    }
}
