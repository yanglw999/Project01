package Exercise15;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise15_16 extends Application {
    @Override
    public void start(Stage primaryStage){
        Pane pane = new Pane();
        TwoBallsPane twoBallsPane = new TwoBallsPane();
        pane.getChildren().add(twoBallsPane);

        pane.setOnMouseDragged( e ->{
          if(twoBallsPane.circle1.contains(e.getX(),e.getY())){
              twoBallsPane.setPoint1(e.getX(),e.getY());
          } else if(twoBallsPane.circle2.contains(e.getX(),e.getY())){
              twoBallsPane.setPoint2(e.getX(),e.getY());
          }
          twoBallsPane.getChildren().removeAll(twoBallsPane.line, twoBallsPane.text);

          twoBallsPane.text = new Text();
          // either directly invoke the getDistance(), getTextLocationX(), getTextLocationY()
            // or setDistance(), setTextLocationX()/ setTextLocationY() (Updating role)
            // then invoke variables: distance, TextLocationX, TextLocationY
            twoBallsPane.text.setText(String.valueOf(twoBallsPane.getDistance()));
            twoBallsPane.text.setX(twoBallsPane.getTextLocationX());
            twoBallsPane.text.setY(twoBallsPane.getTextLocationY());

            twoBallsPane.setLineEndPoint1X(); twoBallsPane.setLineEndPoint1Y();
            twoBallsPane.setLineEndPoint2X(); twoBallsPane.setLineEndPoint2Y();

            twoBallsPane.line = new Line(twoBallsPane.lineEndPoint1X, twoBallsPane.lineEndPoint1Y,
                    twoBallsPane.lineEndPoint2X,twoBallsPane.lineEndPoint2Y);

            twoBallsPane.getChildren().addAll(twoBallsPane.line,twoBallsPane.text);
        });
        Scene scene = new Scene(pane, 800,600);
        primaryStage.setTitle("Exercise15_16");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
class TwoBallsPane extends Pane {
    Circle circle1 = new Circle(40,40,10);
    Circle circle2 = new Circle(120,150,10);
    Point2D point1 = new Point2D(circle1.getCenterX(),circle1.getCenterY());
    Point2D point2 = new Point2D(circle2.getCenterX(),circle2.getCenterY());
    // double variables will automatically update once data change,
    // but object needs to create new to replace old
    double distance = (point1).distance(point2);
    double sin = (circle2.getCenterX() - circle1.getCenterX()) / distance;
    double cos = (circle2.getCenterY() - circle1.getCenterY()) / distance;

    double lineEndPoint1X = circle1.getCenterX() + circle1.getRadius() * sin;
    double lineEndPoint1Y = circle1.getCenterY() + circle1.getRadius() * cos;
    double lineEndPoint2X = circle2.getCenterX() - circle2.getRadius() * sin;
    double lineEndPoint2Y = circle2.getCenterY() - circle2.getRadius() * cos;
    double textLocationX = circle1.getCenterX() + (distance / 2) * sin;
    double textLocationY = circle1.getCenterY() + (distance / 2) * cos;

    Line line = new Line(lineEndPoint1X,lineEndPoint1Y,lineEndPoint2X,lineEndPoint2Y);
    Text text = new Text();

    public TwoBallsPane(){
        circle1.setFill(Color.RED);
        circle2.setFill(Color.GREEN);
        text.setText(String.valueOf(distance)); //String.format("%.2f", distance);
        text.setX(textLocationX);
        text.setY(textLocationY);

        getChildren().addAll(circle1,circle2,line,text);
    }

    public void setPoint1(double x1, double y1){
        circle1.setCenterX(x1);
        circle1.setCenterY(y1);

    }
    public void setPoint2( double x2,double y2) {
        circle2.setCenterX(x2);
        circle2.setCenterY(y2);
    }

    public void setDistance() {
        this.distance = getDistance();
    }

    public double getDistance() {
        Point2D point1 = new Point2D(circle1.getCenterX(),circle1.getCenterY());
        Point2D point2 = new Point2D(circle2.getCenterX(),circle2.getCenterY());
        double distance = (point1).distance(point2);
        return distance;
    }

    public double getTextLocationX() {
        textLocationX = circle1.getCenterX() + (getDistance() / 2) * sin;
        return textLocationX;
    }

    public double getTextLocationY() {
        textLocationY = circle1.getCenterY() + (getDistance() / 2) * cos;
        return textLocationY;
    }

    public void setLineEndPoint1X() {
        this.lineEndPoint1X = circle1.getCenterX() + circle1.getRadius() * sin;
    }

    public void setLineEndPoint1Y() {
        this.lineEndPoint1Y = circle1.getCenterY() + circle1.getRadius() * cos;
    }

    public void setLineEndPoint2X() {
        this.lineEndPoint2X = circle2.getCenterX() - circle2.getRadius() * sin;
    }

    public void setLineEndPoint2Y() {
        this.lineEndPoint2Y = circle2.getCenterY() - circle2.getRadius() * cos;
    }
}