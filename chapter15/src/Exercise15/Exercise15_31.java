package Exercise15;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise15_31 extends Application {
    double angleDegree = Math.PI  / 3;
    //int sign = 1;
    @Override
    public void start(Stage primaryStage){
        Pane pane = new StackPane();
        Swing swing = new Swing();
        pane.getChildren().add(swing);

        pane.widthProperty().addListener( ov -> swing.setW(pane.getWidth()));
        pane.heightProperty().addListener(ov -> swing.setH(swing.getHeight()));



        EventHandler<ActionEvent> eventHandler = e -> {
            swing.setAngle(angleDegree);

            angleDegree = angleDegree - (swing.getUnit()) * swing.getSign();

            if(angleDegree <= - Math.PI  / 3){
               //sign = - sign;
               swing.setSign(- swing.getSign());
            }
            if(angleDegree >=  Math.PI  / 3){
               // sign = - sign;
                swing.setSign(- swing.getSign());
            }
        };

        Timeline animation = new Timeline(new KeyFrame(Duration.millis(100), eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.setAutoReverse(true);
        animation.play();

        swing.setOnKeyPressed( e -> {
            switch (e.getCode()){
                case DOWN:  swing.setUnit(swing.getUnit() > (Math.PI / 30)? swing.getUnit() - Math.PI / 180 : 0); break;
                case UP: swing.setUnit(swing.getUnit() + Math.PI / 30);break;
                case S: animation.pause(); break;
                case R: animation.play(); break;
            }
        });

        Scene scene = new Scene(pane,1000,600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise15_31");
        primaryStage.show();

        swing.requestFocus();

    }
}
class Swing extends Pane {
    private Circle circle1 = new Circle(3);
    private Circle circle2 = new Circle(10);
    private Line line = new Line();
    private double w = 1600;
    private double h = 600;
    private double topY = h * .15;
    private double angle = Math.PI * 2 / 3; // 60
    private double lineLength = h * .7;
    private int sign = 1;
    private double unit = Math.PI / 30;
    public Swing (){
        circle1.setCenterX( w / 2);
        circle1.setCenterY(topY);
       // circle2.setCenterX(w / 2);
       // circle2.setCenterY(h * 0.7);
        circle2.setFill(Color.GREEN);
        line.setStartX(circle1.getCenterX());
        line.setStartY(circle1.getCenterY());
        line.setEndX(circle2.getCenterX());
        line.setEndY(circle2.getCenterY());
        getChildren().addAll(circle1,circle2,line);

    }

    public void setCircle2( double angle) {
        circle2.setCenterX(w / 2 - ((lineLength + circle2.getRadius()) * Math.sin(angle)));
        circle2.setCenterY( topY +  ((lineLength + circle2.getRadius()) * Math.cos(angle)));
    }

    public void setAngle(double angle) {
        this.angle = angle;
        setValues();
    }

    public double getAngle() {
        return angle;
    }

    public void setValues(){
        setCircle2(angle);
        line.setStartX(circle1.getCenterX());
        line.setStartY(circle1.getCenterY());
        line.setEndX(w / 2 - ((lineLength) * Math.sin(angle)));
        line.setEndY(topY +  ((lineLength) * Math.cos(angle)));
    }

    public void setW(double w) {
        this.w = w;
    }

    public void setH(double h) {
        this.h = h;
    }

    public int getSign() {
        return sign;
    }

    public void setSign(int sign) {
        this.sign = sign;
    }

    public void setUnit(double unit) {
        this.unit = unit;
    }

    public double getUnit() {
        return unit;
    }
}
