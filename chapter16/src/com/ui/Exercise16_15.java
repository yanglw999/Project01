package com.ui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Exercise16_15 extends Application {
    private ComboBox<String> cobxPosition = new ComboBox<>();
    private ComboBox<Integer> cobxGap = new ComboBox<>();
    private ImageView grapeImage = new ImageView("image/grapes.gif");
    private Label grapeDisplay = new Label("grapes",grapeImage);
    private String[] list = {"Left","Right","Top","Bottom"};
    private double w = 400;
    private int unit = (int)w / 10;
    @Override
    public void start(Stage primaryStage){
        BorderPane borderPane = new BorderPane();
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(new Label("contentDisplay: "), cobxPosition, new Label("graphicTextGap: "),cobxGap);
        borderPane.setPadding(new Insets(5));
        borderPane.setTop(hBox);
        //Pane pane = new Pane();
        //pane.getChildren().add(grapeDisplay);
        borderPane.setCenter(grapeDisplay);

        borderPane.widthProperty().addListener(ov ->{
            setW( borderPane.getWidth());
            unit = (int) w / 10;
        });


        ObservableList<String> position = FXCollections.observableArrayList(list);
        cobxPosition.getItems().addAll(position);
        cobxPosition.setValue(position.get(0));

        for(int i = unit; i <= w; i = i + unit){
            cobxGap.getItems().add(i);
        }
        cobxGap.setValue(unit);
        cobxPosition.setOnAction( e -> setPosition());
        cobxGap.setOnAction(e -> setPosition());

        Scene scene = new Scene(borderPane, 800, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise16_15");
        primaryStage.show();
    }
    private void setPosition(){
       if(cobxPosition.getValue() == "Left"){
           grapeDisplay.setContentDisplay(ContentDisplay.LEFT);
       }else if(cobxPosition.getValue() == "Right"){
           grapeDisplay.setContentDisplay(ContentDisplay.RIGHT);
        }else if(cobxPosition.getValue() == "Top"){
           grapeDisplay.setContentDisplay(ContentDisplay.TOP);
       } else if(cobxPosition.getValue() == "Bottom"){
           grapeDisplay.setContentDisplay(ContentDisplay.BOTTOM);
       }

        for(int i = unit; i <= w; i = i + unit){
            cobxGap.getItems().add(i);
        }
       grapeDisplay.setGraphicTextGap(cobxGap.getValue());
    }

    private void setW(double width){
        this.w = width;
    }
}
