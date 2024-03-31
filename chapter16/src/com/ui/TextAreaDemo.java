package com.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;

public class  TextAreaDemo extends Application {
    @Override
    public void start(Stage primary){
        DescriptionPane descriptionPane = new DescriptionPane();
        descriptionPane.setTitle("Canada");
        descriptionPane.setDescription("national flag is comprised of a piece of red maple and two red volumes displayed in both sides,"
        + " canada is a diverse nation with the residents from various culture...");

        File file = new File("E:\\Study_coding\\IDEA_workspace\\Image","canada.jpg");
        String url = file.toURI().toString();
        Image image = new Image(url);
        double width = image.getWidth();
        double height = image.getHeight();
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(width * .1);
        imageView.setFitHeight(height * .1);


        descriptionPane.setImageView(imageView);

        Scene scene = new Scene(descriptionPane,450,200);
        primary.setScene(scene);
        primary.setTitle("TextAreaDemo");
        primary.show();

    }
}
