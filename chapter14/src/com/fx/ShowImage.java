package com.fx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;

public class ShowImage extends Application {
    @Override
    public void start(Stage primary){
        Pane pane = new HBox(10);
        pane.setPadding(new Insets(70,5,5,5));
        //XXX Image image1 = new Image("file: E:\\Study_coding\\IDEA_workspace\\Image\\Flag_canada.jpg ");
        File file = new File("E:\\Study_coding\\IDEA_workspace\\Image","canada.jpg");
        String url = file.toURI().toString();
        //
        Image image1 = new Image(url);
        double width = image1.getWidth();
        double height = image1.getHeight();
        ImageView imageView1 = new ImageView(image1);
        imageView1.setFitHeight(height * .053);
        imageView1.setFitWidth(width * .053);
        //pane.getChildren().add(imageView1);
        //
        ImageView imageView2 = new ImageView(image1);
        imageView2.setFitHeight(height *.14);
        imageView2.setFitWidth(width *.14);
       // pane.getChildren().add(imageView2);
        //
        ImageView imageView3 = new ImageView(image1);
        imageView3.setRotate(90);
        imageView3.setFitHeight(height * .2);
        imageView3.setFitWidth(width * .2);
        pane.getChildren().addAll(imageView1,imageView2,imageView3);
        Scene sc = new Scene(pane,400,400);

        primary.setTitle("Show Image");
        primary.setScene(sc);
        primary.show();
    }

    public static void main(String[] args) {
        Application.launch();
    }
}
