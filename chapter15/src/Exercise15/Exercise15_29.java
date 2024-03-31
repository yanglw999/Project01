package Exercise15;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
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
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise15_29 extends Application {
    Car car = new Car();


    @Override
    public void start(Stage primaryStage){
        BorderPane pane = new BorderPane();
        pane.setCenter(car);

        Button b1 = new Button("   Start   ");
        Button b2 = new Button("Accelerator");
        Button b3 = new Button("   Brake   ");
        Button b4 = new Button("    Stop   ");
        Button b5 = new Button("  Reverse  ");


        EventHandler<ActionEvent> eventHandler = e -> car.move();

        Timeline animation = new Timeline(new KeyFrame(Duration.millis(100),eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.setAutoReverse(false);
        animation.play();

        b1.setOnAction( e -> car.startEngine());
        b2.setOnAction( e -> car.accelerator());
        b3.setOnAction(e -> car.brake());
        b4.setOnAction( e ->car.shutEngine());
        b5.setOnAction( e ->car.reverse());

        HBox hBox = new HBox(20);
        hBox.setPadding(new Insets(10));
        hBox.getChildren().addAll(b1,b2,b5,b3,b4);
        hBox.setAlignment(Pos.CENTER);
        pane.setBottom(hBox);


        Scene scene = new Scene(pane,800,600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise15_29");
        primaryStage.show();
    }
}
class Car extends Pane{
    double xOrigin = 0;
    double yOrigin = 300;
    double wheelRadius = 10;
    double speed = 0;
    double unitOfSpeed = 5;
    boolean engine = false;

    Circle wheel1 = new Circle();
    Circle wheel2 = new Circle();
    Rectangle rectangle = new Rectangle();
    Polygon top = new Polygon();
    ObservableList<Double> list = top.getPoints();


    public Car(){
        wheel1.setCenterX(xOrigin + 3 * wheelRadius);
        wheel1.setCenterY(yOrigin - wheelRadius);
        wheel1.setRadius(wheelRadius);
        wheel1.setStrokeWidth(2);
        wheel1.setFill(Color.gray(.5,.5));
        wheel1.setStroke(Color.BLACK);
        wheel2.setCenterX(xOrigin + 7 * wheelRadius);
        wheel2.setCenterY(yOrigin - wheelRadius);
        wheel2.setRadius(wheelRadius);
        wheel2.setStrokeWidth(2);
        wheel2.setFill(Color.gray(.5,.5));
        wheel2.setStroke(Color.BLACK);

        rectangle.setX(xOrigin);
        rectangle.setY(yOrigin - 2 * (2 * wheelRadius));
        rectangle.setWidth(5 * (2 * wheelRadius));
        rectangle.setHeight( 2 * wheelRadius);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.RED);

        top.setFill(Color.WHITE);
        top.setStroke(Color.GREEN);


        list.add(xOrigin + 4 * wheelRadius);      list.add(yOrigin - 6 * wheelRadius);
        list.add(xOrigin + 6 * wheelRadius);      list.add(yOrigin - 6 * wheelRadius);
        list.add(xOrigin + 8 * wheelRadius);      list.add(yOrigin - 4 * wheelRadius);
        list.add(xOrigin + 2 * wheelRadius);      list.add(yOrigin - 4 * wheelRadius);

        getChildren().addAll(wheel1, wheel2, rectangle,top);
    }

    public void setXOrigin() {
        this.xOrigin = getXOrigin() + speed;
    }

    public double getXOrigin() {
        return xOrigin;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void accelerator(){
        if(engine)
        this.speed = getSpeed() + unitOfSpeed;
    }
    public void brake(){
        if(engine) {
            if (speed < 0 && Math.abs(speed) > Math.abs(unitOfSpeed)) {
                this.speed = (getSpeed() <= unitOfSpeed) ? getSpeed() - unitOfSpeed : 0;
            } else {
                this.speed = (Math.abs(getSpeed()) >= Math.abs(unitOfSpeed)) ? getSpeed() - unitOfSpeed : 0;
            }
        }
    }
    public void reverse(){
        if(engine) {
            setSpeed(-speed);
            this.unitOfSpeed = -unitOfSpeed;
        }
    }
    public void move(){
        setXOrigin();
        setValues();
    }

    public void setEngine(boolean engine) {
        this.engine = engine;
    }

    public void startEngine(){
        setSpeed(5);
        setEngine(true);
    }
    public void shutEngine(){
        setEngine(false);
        setSpeed(0);
    }
    public void setValues(){
        wheel1.setCenterX(xOrigin + 3 * wheelRadius);
        wheel1.setCenterY(yOrigin - wheelRadius);
        wheel2.setCenterX(xOrigin + 7 * wheelRadius);
        wheel2.setCenterY(yOrigin - wheelRadius);

        rectangle.setX(xOrigin);
        rectangle.setY(yOrigin - 2 * (2 * wheelRadius));

       list.clear();

        list.add(xOrigin + 4 * wheelRadius);      list.add(yOrigin - 6 * wheelRadius);
        list.add(xOrigin + 6 * wheelRadius);      list.add(yOrigin - 6 * wheelRadius);
        list.add(xOrigin + 8 * wheelRadius);      list.add(yOrigin - 4 * wheelRadius);
        list.add(xOrigin + 2 * wheelRadius);      list.add(yOrigin - 4 * wheelRadius);
    }

}
