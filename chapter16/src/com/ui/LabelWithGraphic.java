package com.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

import java.io.File;

public class LabelWithGraphic extends Application {
    @Override
    public void start(Stage primary){
        Circle circle = new Circle(100,100,50);
        Label label = new Label("Circle", circle);// label contains string and circle
        label.setStyle("-fx-border-color: RED; -fx-fill: Green");
        circle.setStyle("-fx-fill: YELLOW; -fx-stroke-width: 7;-fx-border-color: Black");
        label.setContentDisplay(ContentDisplay.BOTTOM);

        StackPane stackPane = new StackPane();
        Ellipse ellipse = new Ellipse(200,100,60,40);
        ellipse.setFill(Color.GREEN);
        //stackPane.getChildren().addAll(new Label("Java"),ellipse);
        stackPane.getChildren().addAll(ellipse, new Label("Java"));
        Label label1 = new Label("a pane inside a label",stackPane);
        label1.setContentDisplay(ContentDisplay.LEFT);

        File file = new File("E:\\Study_coding\\IDEA_workspace\\Project01\\chapter14\\src\\com\\Image\\Flag_china.png");
        String url = file.toURI().toString();
        Image image = new Image(url);
        double width = image.getWidth();
        double height = image.getHeight();
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(height * .1);
        imageView.setFitWidth(width * .1);

        Label label2 = new Label("China",imageView);
        label2.setTextFill(Color.RED);
        label2.setGraphicTextGap(5);// .setGraphicTextGap()
        label2.setContentDisplay(ContentDisplay.TOP);

        HBox hBox = new HBox(20);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(label,label1,label2);

        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(2,3,4,2));
        borderPane.setCenter(hBox);


        Scene scene = new Scene(borderPane);
        primary.setTitle("label with graphic");
        primary.setScene(scene);
        primary.show();
    }
}
