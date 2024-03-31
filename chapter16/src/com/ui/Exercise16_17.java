package com.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Exercise16_17 extends Application {
    Label label = new Label("How did it go?");
    ScrollBar redSbl = new ScrollBar();
    ScrollBar greenSbl = new ScrollBar();
    ScrollBar blueSbl = new ScrollBar();
    ScrollBar opacitySbl = new ScrollBar();
    @Override
    public void start(Stage primaryStage){
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(5));
        borderPane.setCenter(label);
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(5);
        gridPane.setAlignment(Pos.BOTTOM_LEFT);
        gridPane.add(new Label("Red "),0,0);
        gridPane.add(redSbl,1,0);
        gridPane.add(new Label("Green "),0,1);
        gridPane.add(greenSbl,1,1);
        gridPane.add(new Label("Blue "),0,2);
        gridPane.add(blueSbl,1,2);
        gridPane.add(new Label("Opacity "),0,3);
        gridPane.add(opacitySbl,1,3);

        HBox hAll = new HBox(10);
        hAll.setAlignment(Pos.CENTER);
        hAll.getChildren().add(gridPane);
        borderPane.setBottom(hAll);

        borderPane.widthProperty().addListener(ov -> {
            gridPane.setMaxWidth(borderPane.getWidth() / 2);
            hAll.setPrefWidth(borderPane.getWidth());
        });

        redSbl.valueProperty().addListener( ov -> setColor());
        greenSbl.valueProperty().addListener( ov -> setColor());
        blueSbl.valueProperty().addListener( ov -> setColor());
        opacitySbl.valueProperty().addListener( ov -> setColor());

        Scene scene = new Scene(borderPane, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise16_17");
        primaryStage.show();
    }
    private void setColor(){
        double red = redSbl.getValue() / redSbl.getMax();
        double green = greenSbl.getValue() / greenSbl.getMax();
        double blue = blueSbl.getValue() / blueSbl.getMax();
        double opacity = opacitySbl.getValue() / opacitySbl.getMax();
        label.setTextFill(Color.color(red,green,blue,opacity));

        if(redSbl.isPressed()){
            label.setFont(new Font(red * 100));
        }else if(greenSbl.isPressed()){
            label.setFont(new Font(green * 100));
        }else if(blueSbl.isPressed()){
            label.setFont(new Font(blue * 100));
        }

    }
}
