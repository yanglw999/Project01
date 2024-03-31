package com.ui;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SliderDemo extends Application {
    @Override
    public void start(Stage primaryStage){
        Text text = new Text(50,50, "Merry Christmas! ");
        text.setFill(Color.color(0.8,.3,.4,.9));
        text.setFont(new Font(26));

        Slider sliderVertical = new Slider();
        sliderVertical.setOrientation(Orientation.VERTICAL);
        sliderVertical.setShowTickLabels(true);
        sliderVertical.setValue(50); // set the text y location

        Slider sliderHorizontal = new Slider(10, 150, 80);
        sliderHorizontal.setShowTickMarks(true);
        sliderHorizontal.setShowTickLabels(true);


        Pane paneForText = new Pane(text);
        BorderPane borderPane = new BorderPane();
        borderPane.setRight(sliderVertical);
        borderPane.setBottom(sliderHorizontal);
        borderPane.setCenter(paneForText);

        text.xProperty().bind(sliderHorizontal.valueProperty().divide(sliderHorizontal.maxProperty()).multiply(paneForText.widthProperty()));

        sliderVertical.valueProperty().addListener( ov ->{
            text.setY((sliderVertical.getMax() - sliderVertical.getValue() ) / sliderVertical.getMax() * paneForText.getWidth());
        });

        Scene scene = new Scene(borderPane,800,600);
        primaryStage.setTitle("Slider Demo");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
