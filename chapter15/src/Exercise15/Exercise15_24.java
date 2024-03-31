package Exercise15;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise15_24 extends Application {
    double paneWith = 800;
    double paneHeight = 600;
    double x = paneWith * .5;
    double y = paneHeight * 0.5;
    double radiusX = paneWith / 3;
    double radiusY = paneHeight / 3;
    @Override
    public void start(Stage primaryStage){
        Pane pane = new Pane();
        Circle circle = new Circle(10);
        circle.setFill(Color.GREEN);
        Arc arc = new Arc(x,y,radiusX,radiusY,210, 120);
        arc.setType(ArcType.OPEN);
        arc.setFill(Color.WHITE);
        arc.setStroke(Color.RED);

        //arc.centerXProperty().bind(pane.widthProperty().divide(2));
        //arc.centerYProperty().bind(pane.heightProperty().divide(2));

        pane.getChildren().addAll( arc, circle);

        PathTransition path = new PathTransition();
        path.setDuration(Duration.millis(3000));
        path.setPath(arc);
        path.setNode(circle);
        path.setCycleCount(Timeline.INDEFINITE);
        path.setAutoReverse(true);
        path.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        path.play();

        arc.setOnMousePressed( e -> path.pause());
        arc.setOnMouseReleased(e ->{
            path.play();
        });

        Scene scene = new Scene(pane,800,600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise15_24");
        primaryStage.show();

        scene.widthProperty().addListener( ov -> {
            paneWith = pane.getWidth();
            setValues();
        });
        scene.heightProperty().addListener( ov ->{
            paneHeight = pane.getHeight();
            setValues();
        });

    }
    private void setValues(){
         x = paneWith * .5;
         y = paneHeight * 0.5;
         radiusX = paneWith / 3;
         radiusY = paneHeight / 3;
    }
}
