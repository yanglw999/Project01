package Exercise15;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;

public class Exercise15_17 extends Application {
    double radius = 10;
    @Override
    public void start(Stage primaryStage){
        Pane pane = new Pane();
        Rectangle boundingRectangle  = new Rectangle();
        boundingRectangle.setFill(Color.WHITE);
        boundingRectangle.setStroke(Color.RED);

        pane.getChildren().add(boundingRectangle);
        pane.setOnMouseClicked(e -> {
            if(e.getButton() == MouseButton.PRIMARY){
                Circle circle = new Circle(e.getX(),e.getY(),radius);
                circle.setFill(Color.color(Math.random(),Math.random(),Math.random(),Math.random()));
                pane.getChildren().add(circle);
            }else if(e.getButton() == MouseButton.SECONDARY){
                ObservableList<Node> list = pane.getChildren();
                for (int i = 0; i < list.size(); i++){
                    if(list.get(i) instanceof Circle && list.get(i).contains(e.getX(),e.getY())){
                        pane.getChildren().remove(list.get(i)); //list.remove()
                    }
                }
            }
            ArrayList<Double> xList = new ArrayList<>();
            ArrayList<Double> yList = new ArrayList<>();
            for(Node node : pane.getChildren()){
                if(node instanceof Circle){
                    xList.add(((Circle)node).getCenterX());
                    yList.add(((Circle)node).getCenterY());
                }
            }
            double minX = Collections.min(xList);
            double maxX = Collections.max(xList);
            double minY = Collections.min(yList);
            double maxY = Collections.max(yList);

            boundingRectangle.setX(minX - radius);
            boundingRectangle.setY(minY - radius);
            boundingRectangle.setWidth((maxX + radius) - (minX - radius));
            boundingRectangle.setHeight((maxY + radius) - (minY - radius));
        });
/*
            ObservableList<Node> latestList = pane.getChildren();
            double [] xList = new double[latestList.size()];
            double [] yList = new double[latestList.size()];
            for (int i = 0; i < latestList.size(); i++){
                xList[i] = latestList.get(i).getScaleX();
                yList[i] = latestList.get(i).getScaleY();
            }
            Arrays.sort(xList);
            Arrays.sort(yList);
            Rectangle rectangle = new Rectangle(xList[0],yList[0],
                    xList[latestList.size() -1] - xList[0],yList[latestList.size() -1 ] - yList[0]);
            pane.getChildren().add(rectangle);*/

        Scene scene = new Scene(pane, 800,600);
        primaryStage.setTitle("Exercise15_17");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
class BorderRectangle extends Pane{
    // can not create an independent pane,since it must share the pane will circles
    public BorderRectangle(){

    }
}
