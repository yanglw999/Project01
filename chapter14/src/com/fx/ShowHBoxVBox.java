package com.fx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ShowHBoxVBox extends Application {
    @Override
    public void start(Stage primary){

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(getHBox());
        borderPane.setLeft(getVBox());

        Scene scene = new Scene(borderPane);
        primary.setTitle("Show HBoxVBox");
        primary.setScene(scene);
        primary.show();
    }

    public static void main(String[] args) {
        Application.launch();
    }
    private HBox getHBox (){
        HBox hBox = new HBox(15);
        hBox.setPadding(new Insets(15,15,15,15));
        hBox.setStyle("-fx-border-color: GOLD;");
        hBox.getChildren().add(new Button("Computer Science"));
        hBox.getChildren().add(new Button("Chemistry"));


       /* File file = new File("E:\\Study_coding\\IDEA_workspace\\Project01\\Image\\Flag_canada.jpg");
        String url = file.toURI().toString();
        Image image = new Image(url);
        double width = image.getWidth();
        double height = image.getHeight();
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(height * .03);
        imageView.setFitWidth(width * .03);
*/
        hBox.getChildren().add(new ImageView("image/ca.gif"));
        return hBox;
    }
    private VBox getVBox(){
        VBox vBox = new VBox(15);
        vBox.setPadding(new Insets(15,5,5,5));
        vBox.getChildren().add(new Label("Course"));
        Label[]courses ={new Label("CSCI 1301"), new Label("CSCI 1302"),
                new Label("CSCI 2410"), new Label("CSCI 3720")};
        for (Label course : courses){
            vBox.getChildren().add(course);
        }
        return vBox;

    }
}
