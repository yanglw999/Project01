package Exercise15;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise15_30 extends Application {
    int i = 0; // replace loop
    @Override
    public void start(Stage primaryStage){
        Pane pane = new Pane();
        ImageView imageView = new ImageView();
        imageView.setFitWidth(800);
        imageView.setFitHeight(600);
        pane.getChildren().add(imageView);

        EventHandler<ActionEvent> eventHandler = e ->{
            imageView.setImage(new Image("image/slide" + i + ".jpg"));
            i++;
            if(i > 24){
                i = 0;
            }
        };

        Timeline animation = new Timeline(new KeyFrame(Duration.seconds(1),eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.setAutoReverse(true);
        animation.play();

        pane.setOnMouseClicked( e ->{
            if(animation.getStatus() == Animation.Status.PAUSED){
                animation.play();
            }else{
                animation.pause();
            }
        });

        Scene scene = new Scene(pane,800,600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise15_30");
        primaryStage.show();
    }
}
