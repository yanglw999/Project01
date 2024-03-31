package Exercise15;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Exercise15_9 extends Application {
    double startX = 300;
    double startY = 300;
    //double endY = 300;
    //double endX = 300;
    // Line lineUp;                                                             wrong idea 1
    // Line  lineLeft = new Line(startX, startY, startX -100,endY);;            wrong idea 2

    @Override
    public void start(Stage primaryStage){
        Pane pane = new Pane();

       /* pane.setOnKeyPressed( e -> {
            if(e.getCode() == KeyCode.DOWN){
            Line lineDown = new Line(startX,startY,endX,startY + 100);
            startY = lineDown.getEndY(); startX = lineDown.getEndX();
                pane.getChildren().add(lineDown);
        }}); */
 // below is wrong, because lineUp is not an object, it cannot be controlled by keyboard
        /*lineUp.setOnKeyTyped( e -> {
            if(e.getCode() == KeyCode.UP){
                 lineUp = new Line(startX,startY,endX,startY - 100);
                startY = lineUp.getEndY(); startX = lineUp.getEndX();
                pane.getChildren().add(lineUp);
            }
        });
        */
        //although creating the object before pressed keyboard, it's illogical, because we need to create the object after pressing key
      /*  lineLeft.setOnKeyTyped( e ->{
            if(e.getCode() == KeyCode.LEFT){
                startX = lineLeft.getEndX(); startY = lineLeft.getEndY();
                pane.getChildren().add(lineLeft);
            }
        }); */

        pane.setOnKeyPressed( e ->{
            switch (e.getCode()){
                case DOWN: Line lineDown = new Line(startX,startY,startX,startY + 100);
                startY = lineDown.getEndY(); startX = lineDown.getEndX();
                    pane.getChildren().add(lineDown); break;
                case UP: Line lineUp = new Line(startX,startY,startX,startY - 100);
                startY = lineUp.getEndY(); startX = lineUp.getEndX();
                    pane.getChildren().add(lineUp);break;
                case LEFT: Line lineLeft = new Line(startX, startY, startX -100,startY);
                startX = lineLeft.getEndX(); startY = lineLeft.getEndY();
                    pane.getChildren().add(lineLeft);break;
                case RIGHT: Line lineRight = new Line(startX,startY, startX + 100, startY);
                startX = lineRight.getEndX(); startY = lineRight.getEndY();
                    pane.getChildren().add(lineRight);break;
            }
        });
    Scene scene = new Scene(pane,600, 500);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Exercise15_9");
            primaryStage.show();

            pane.requestFocus();
    }
}
