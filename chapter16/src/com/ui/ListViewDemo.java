package com.ui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.File;

public class ListViewDemo extends Application {
    String[]flagTitle = {"Canada","China"}; //1
    File file1 = new File("E:\\Study_coding\\IDEA_workspace\\Image\\canada.jpg");
    String url1 = file1.toURI().toString();
    Image image1 = new Image(url1);
    double width = image1.getWidth();
    double height = image1.getHeight();

    ImageView imageView1 = new ImageView(image1);

    File file2 = new File("E:\\Study_coding\\IDEA_workspace\\Image\\china.png");
    String url2 = file2.toURI().toString();

    ImageView[] flagImage={imageView1, new ImageView(url2)}; // 2
    @Override
    public void start(Stage primaryStage){
        imageView1.setFitWidth(width * .1);
        imageView1.setFitHeight(height * .1);
        ListView<String> lv = new ListView<>(FXCollections.observableArrayList(flagTitle)); //
        lv.setPrefSize(400,400);
        lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        BorderPane borderPane = new BorderPane();
        FlowPane flowPane = new FlowPane(10,10);
        borderPane.setLeft(new ScrollPane(lv));
        borderPane.setCenter(flowPane);

        lv.getSelectionModel().selectedItemProperty().addListener(ov ->{
            flowPane.getChildren().clear();
            for(Integer i : lv.getSelectionModel().getSelectedIndices()){
                flowPane.getChildren().add(flagImage[i]); }
        });
        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ListViewDemo");
        primaryStage.show();
    }

}
