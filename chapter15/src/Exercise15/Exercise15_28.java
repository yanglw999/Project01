package Exercise15;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise15_28 extends Application {

    @Override
    public void start(Stage primaryStage){
        BorderPane bp = new BorderPane();
        FanPane fanPane = new FanPane();
        //StackPane stackPane = new StackPane();
        //stackPane.getChildren().add(fanPane);

        bp.setCenter(fanPane);

        Button btPause = new Button("Pause");
        Button btResume = new Button("Resume");
        Button btReverse = new Button("Reverse");
        HBox hBox = new HBox(25);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(3,3,5,3));
        hBox.getChildren().addAll(btPause,btResume,btReverse);

        bp.setBottom(hBox);

        Scene scene = new Scene(bp,800,600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise15_24");
        primaryStage.show();

        EventHandler<ActionEvent> eventHandler = e ->{ fanPane.move(); };
        Timeline animation = new Timeline(
                new KeyFrame(Duration.millis(100),eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        btPause.setOnAction( e -> animation.pause());
        btReverse.setOnAction(e -> fanPane.reverse());
        btResume.setOnAction( e -> animation.play());
    }
}
class FanPane extends Pane { // StackPane did not work well here
    double startAngle = 0;
    double increment = 5;
    double radius = 110;

    Circle circle = new Circle(100,100,radius);
    Arc []arc = new Arc[4];

    public FanPane(){
        circle.centerXProperty().bind(widthProperty().divide(2));
        circle.centerYProperty().bind(heightProperty().divide(2));
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        getChildren().add(circle);

        for(int i = 0; i < 4; i++){
            arc[i] = new Arc(circle.getCenterX(),circle.getCenterY(),radius * 0.88,radius * 0.88,
                    startAngle + 90 * i,35);
            arc[i].centerXProperty().bind(widthProperty().divide(2));
            arc[i].centerYProperty().bind(heightProperty().divide(2));
            arc[i].setType(ArcType.ROUND);
            arc[i].setFill(Color.color(Math.random(),Math.random(),Math.random()));
            /* arc.setRotate(30 + 90 * i); */ // setRotate() is not proper to be used here
            getChildren().add(arc[i]);
        }
    }
    public void setStartAngle(double angle){
        startAngle = angle;
        setValues();
    }
    public void move(){
        setStartAngle(getStartAngle() + increment);
        setValues();
    }
    public double getStartAngle(){
        return startAngle;
    }
    public void reverse(){
        increment = - increment;
    }
    public void setValues(){
        for(int i = 0; i < 4; i++){ // for the sake of update instead of create new object
           //wrong  arc[i] = new Arc(circle.getCenterX(),circle.getCenterY(),radius * 0.88,radius * 0.88,
            //        startAngle + 90 * i,35);
           // arc[i].centerXProperty().bind(widthProperty().divide(2));
           // arc[i].centerYProperty().bind(heightProperty().divide(2));

            arc[i].setFill(Color.color(Math.random(),Math.random(),Math.random()));
            arc[i].setStartAngle(getStartAngle() + 90 * i);
        }
    }
}
