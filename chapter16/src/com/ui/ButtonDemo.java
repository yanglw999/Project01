package com.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ButtonDemo extends Application {
    //@Override
        Text text = new Text(200,200,"JavaFX programming is fun.");

        BorderPane getPane(){
            HBox hBox = new HBox(40);
            javafx.scene.control.Button btLeft  = new javafx.scene.control.Button("Left");//
            javafx.scene.control.Button btRight = new Button("Right");
            hBox.setAlignment(Pos.CENTER);
            hBox.getChildren().addAll(btLeft, btRight);
            hBox.setStyle("-fx-border-color: GREEN");

            Pane paneText = new Pane();// the reason to use Pane instead of stackPane is text will move in the center of BoardPane
            paneText.getChildren().add(text);

            BorderPane borderPane = new BorderPane();
            borderPane.setPadding(new Insets(20,20,50,30));
            borderPane.setStyle("-fx-border-color: RED");
            borderPane.setBottom(hBox);
            borderPane.setCenter(paneText);

            // EventHandler<ActionEvent> eventHandler = e ->{text.setX(text.getX() - 10);};
            //btLeft.setOnMouseClicked(eventHandler);  // actionEvent

            btLeft.setOnMouseClicked(e ->{text.setX(text.getX() - 10);});// mouse event
            btRight.setOnMouseClicked(e -> text.setX(text.getX() + 10));
            return borderPane;
      }
      @Override
      public void start(Stage primary){
            // the setting of text style must be start() method
          text.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC,20));
          text.setFill(Color.color(Math.random(), Math.random(), Math.random(), 0.5));
        Scene scene = new Scene(getPane());
        primary.setTitle("ButtonDemo");
        primary.setScene(scene);
        primary.show();

      }
}
