package com.ui;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Exercise16_10 extends Application {
    @Override
    public void start(Stage primaryStage){
        BorderPane borderPane = new BorderPane();
        Pane pane = new Pane();
        TextArea textArea = new TextArea();
        textArea.setWrapText(true);
        textArea.setPrefColumnCount(100);
        textArea.setPrefRowCount(20);

        pane.getChildren().add(new ScrollPane(textArea));
        borderPane.setCenter(pane);

        ScrollBar vScrollBar = new ScrollBar();
        vScrollBar.setOrientation(Orientation.VERTICAL);
        borderPane.setRight(vScrollBar);

        ScrollBar hScrollBar = new ScrollBar();
        hScrollBar.setOrientation(Orientation.HORIZONTAL);
        Label fileNameLabel = new Label("File name: ");
        TextField textField = new TextField();
        textField.setPrefColumnCount(60);
        Button button = new Button("View");

        HBox hBox = new HBox(5);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(fileNameLabel, textField,button);
        VBox vBox = new VBox(5);
        vBox.getChildren().addAll(hScrollBar,hBox);

        borderPane.setBottom(vBox);

        button.setOnAction( e ->{
            String file = textField.getText().trim();
            try {
                File f = new File(file);
                Scanner input = new Scanner(f);
                while (input.hasNext()){
                    textArea.appendText(input.nextLine() + '\n');
                }
            }
            catch (FileNotFoundException ex){
                System.out.println("File not found: " + file);
            }
            catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        });

       /* vScrollBar.valueProperty().addListener( ov ->{

        }); */


        Scene scene = new Scene(borderPane,800,600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise16_10");
        primaryStage.show();
    }
}
