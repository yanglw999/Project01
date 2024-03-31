package Exercise15;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.Random;

public class Exercise15_20 extends Application {

    @Override
    public void start(Stage primaryStage){
        Pane pane = new Pane();
        TrianglePane triangle = new TrianglePane();
        pane.getChildren().add(triangle);

        pane.setOnMouseDragged( e -> {
            if(triangle.circle1.contains(e.getX(),e.getY())){
                triangle.setP1(new Point2D(e.getX(),e.getY()));

            }else if(triangle.circle2.contains(e.getX(),e.getY())){
                triangle.setP2(new Point2D(e.getX(),e.getY()));

            }else if(triangle.circle3.contains(e.getX(),e.getY())){

                triangle.setP3(new Point2D(e.getX(),e.getY()));

            }
            triangle.setLine1();
            triangle.setLine2();
            triangle.setLine3();


        });
        Scene scene = new Scene(pane,800,600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise15_20");
        primaryStage.show();
    }
}
class TrianglePane extends Pane{
    double radius = 10;
    Circle circle1 = new Circle(new Random().nextInt(500),new Random().nextInt(500), radius);
    Circle circle2 = new Circle(new Random().nextInt(500),new Random().nextInt(500), radius);
    Circle circle3 = new Circle(new Random().nextInt(500),new Random().nextInt(500), radius);
    // degrees
    Point2D p1 = new Point2D(circle1.getCenterX(),circle1.getCenterY());
    Point2D p2 = new Point2D(circle2.getCenterX(),circle2.getCenterY());
    Point2D p3 = new Point2D(circle3.getCenterX(),circle3.getCenterY());
    double dist1and2 = p1.distance(p2);
    double dist2and3 = p2.distance(p3);
    double dist3and1 = p3.distance(p1);

    double sin1a = (circle3.getCenterY() - circle1.getCenterY()) / dist3and1;
    double cos1a = (circle3.getCenterX() - circle1.getCenterX()) / dist3and1;
    double line1AX = circle1.getCenterX() + radius * cos1a;
    double line1AY = circle1.getCenterY() + radius * sin1a;
    double line3AX = circle3.getCenterX() - radius* cos1a;
    double line3AY = circle3.getCenterY() - radius * sin1a;

    double sin2b = (circle1.getCenterY() - circle2.getCenterY()) / dist1and2;
    double cos2b = (circle2.getCenterX() - circle1.getCenterX()) / dist1and2;
    double line1BX = circle1.getCenterX() + radius * cos2b;
    double line1BY = circle1.getCenterY() - radius * sin2b;
    double line2BX = circle2.getCenterX() - radius * cos2b;
    double line2BY = circle2.getCenterY() + radius * cos2b;

    double sin3c = (circle3.getCenterX() - circle2.getCenterX()) / dist2and3;
    double cos3c = (circle3.getCenterY() - circle2.getCenterY()) / dist2and3;
    double line2CX = circle2.getCenterX() + radius * sin3c;
    double line2CY = circle2.getCenterY() + radius * cos3c;
    double line3CX = circle3.getCenterX() - radius * sin3c;
    double line3CY = circle3.getCenterY() - radius * cos3c;


    Line line1 = new Line(line1AX,line1AY,line3AX,line3AY);
    Line line2 = new Line(line1BX,line1BY,line2BX,line2BY); //
    Line line3 = new Line(line2CX,line2CY,line3CX,line3CY);

    public TrianglePane(){
        circle1.setFill(Color.WHITE);
        circle1.setStroke(Color.RED);
        circle2.setFill(Color.WHITE);
        circle2.setStroke(Color.GREEN);
        circle3.setFill(Color.WHITE);
        circle3.setStroke(Color.BLACK);
        getChildren().addAll(circle1,circle2,circle3,line1,line2,line3);
    }

    public void setP1(Point2D p) {
        circle1.setCenterX(p.getX());
        circle1.setCenterY(p.getY());
    }

    public void setP2(Point2D p) {
        circle2.setCenterX(p.getX());
        circle2.setCenterY(p.getY());
    }
    public void setP3(Point2D p){
        circle3.setCenterX(p.getX());
        circle3.setCenterY(p.getY());
    }

    public void setLine1() {
        line1.setStartX(getLine1AX());
        line1.setStartY(getLine1AY());
        line1.setEndX(getLine3AX());
        line1.setEndY(getLine3AY());

    }

    public void setLine2() {
        line2.setStartX(getLine1BX());
        line2.setStartY(getLine1BY());
        line2.setEndX(getLine2BX());
        line2.setEndY(getLine2BY());
    }

    public void setLine3() {
        line3.setStartX(getLine2CX());
        line3.setStartY(getLine2CY());
        line3.setEndX(getLine3CX());
        line3.setEndY(getLine3CY());
    }

    public double getLine1AX() {
        line1AX = circle1.getCenterX() + radius * cos1a;
        return line1AX;
    }

    public double getLine1AY() {
        line1AY = circle1.getCenterY() + radius * sin1a;
        return line1AY;
    }

    public double getLine3AX() {
        line3AX = circle3.getCenterX() - radius* cos1a;
        return line3AX;
    }

    public double getLine3AY() {
        line3AY = circle3.getCenterY() - radius * sin1a;
        return line3AY;
    }

    public double getLine1BX() {
        line1BX = circle1.getCenterX() + radius * cos2b;
        return line1BX;
    }

    public double getLine1BY() {
        line1BY = circle1.getCenterY() - radius * sin2b;
        return line1BY;
    }

    public double getLine2BX() {
        line2BX = circle2.getCenterX() - radius * cos2b;
        return line2BX;
    }

    public double getLine2BY() {
        line2BY = circle2.getCenterY() + radius * cos2b;
        return line2BY;
    }

    public double getLine2CX() {
        line2CX = circle2.getCenterX() + radius * sin3c;
        return line2CX;
    }

    public double getLine2CY() {
        line2CY = circle2.getCenterY() + radius * cos3c;
        return line2CY;
    }

    public double getLine3CX() {
        line3CX = circle3.getCenterX() - radius * sin3c;
        return line3CX;
    }

    public double getLine3CY() {
        line3CY = circle3.getCenterY() - radius * cos3c;
        return line3CY;
    }
}
