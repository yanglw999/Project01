package com.ui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MediaDemo extends Application {
   // private File file = new File("E:\\Study_coding\\IDEA_workspace\\Image\\arbitrage.mkv");
    //private String url = file.toURI().toString();
    String url = "https://www.youtube.com/watch?v=i87Et5E7nhQ";
    @Override
    public void start(Stage primaryStage){
        Media media = new Media(url);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);

        Button button = new Button("play");
        button.setOnAction( e -> {
            if(button.getText() == "play"){
                mediaPlayer.play();
                button.setText("pause");
            }else {
                mediaPlayer.pause();
                button.setText("play");
            }
        });

        Button rewindButton = new Button("<<");
        rewindButton.setOnAction( e -> mediaPlayer.seek(Duration.ZERO));

        Slider sliderVolume = new Slider();
        sliderVolume.setPrefWidth(150);
        sliderVolume.setMinWidth(30);
        sliderVolume.setMaxWidth(Region.USE_COMPUTED_SIZE);
        sliderVolume.setValue(50);

        sliderVolume.valueProperty().addListener(ov -> mediaPlayer.setVolume(sliderVolume.getValue()));

        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(button, rewindButton, new Label("volume"),sliderVolume);

        BorderPane borderPane = new BorderPane();
        borderPane.setBottom(hBox);
        borderPane.setCenter(mediaView);

        Scene scene = new Scene(borderPane, 650,500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Media Demo");
        primaryStage.show();
    }
}
