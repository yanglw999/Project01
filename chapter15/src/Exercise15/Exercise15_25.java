package Exercise15;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise15_25 extends Application {

    @Override
    public void start(Stage primaryStage){
        Pane pane = new Pane();
        double paneWidth = 800;
        double paneHeight = 600;
        Line xLine = new Line(10,paneHeight/2, paneWidth - 10, paneHeight/2);
        Line yLine = new Line(paneWidth/2, 10, paneWidth/2, paneHeight - 10);

        double mid = (xLine.getEndX() - xLine.getStartX()) / 2;
        Polyline curve = new Polyline();
        ObservableList<Double> list = curve.getPoints();
        int  sign = -4;
        for(double i = xLine.getStartX(); i < xLine.getEndX(); i = i + .5){
            list.add(i);
            list.add(Math.sin( (i -(xLine.getStartX() + mid))  / -30) * 100 + paneHeight / 2 );

            if((i -( mid)) % 90 == 0){//(i -(xLine.getStartX() + mid) )
                Text text = new Text();
                if(i - mid == 0){
                    text.setX(i);
                    text.setY(paneHeight / 2 + yLine.getStartY());
                    text.setText("0");
                }else {
                    text.setX(i);
                    text.setY(paneHeight / 2 + yLine.getStartY());
                    text.setText(sign + "π");;
                }
                sign++;
                pane.getChildren().add(text);
            }

        }

        Circle circle = new Circle(10);
        circle.setFill(Color.color(Math.random(),Math.random(),Math.random(),1));

        PathTransition pt = new PathTransition();
        pt.setNode(circle);
        pt.setPath(curve);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(false);
        pt.setDuration(Duration.millis(10000));
        pt.play();

        FadeTransition ft = new FadeTransition();
        ft.setNode(circle);
        ft.setFromValue(1);
        ft.setToValue(0);
        ft.setByValue(0.001);
        ft.setDuration(Duration.millis(1000));
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();


        pane.getChildren().addAll(xLine,yLine,curve,circle);

        pane.setOnMouseClicked( e ->{
            if(e.getButton() == MouseButton.PRIMARY){
                pt.pause();
            }else if(e.getButton() == MouseButton.SECONDARY){
                pt.play();
            }
        });

        Scene scene = new Scene(pane,800,600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise15_24");
        primaryStage.show();


    }
}
