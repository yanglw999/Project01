package com.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Exercise16_4 extends Application {
   static TextField tF1 = new TextField();
   static TextField tF2 = new TextField();
    @Override
    public void start(Stage primaryStage){
        Label label1 = new Label("Mile: ");
        Label label2 = new Label("km: ");
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);

        gridPane.setPadding(new Insets(10));
        gridPane.add(label1,0,0);
        gridPane.add(tF1,1,0);
        gridPane.add(label2,0,1);
        gridPane.add(tF2,1,1);

        StackPane pane = new StackPane();
        pane.getChildren().add(gridPane);

        tF1.setOnKeyPressed(e ->{
            if(e.getCode() == KeyCode.ENTER) {
                Double mile = Double.parseDouble(tF1.getText());
                Double kMCalculate = mile * 1.6023;
                tF2.setText(String.valueOf(kMCalculate));
            }
        });

        tF2.setOnKeyPressed(e ->{
            if(e.getCode() == KeyCode.ENTER) {
                Double km = Double.parseDouble(tF2.getText());
                Double mileCalculate = km / 1.6023;
                tF1.setText(String.valueOf(  new Double(mileCalculate)));
            }
        });

        Scene scene = new Scene(pane,800,600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise16_4");
        primaryStage.show();
    }
    private static void setValue(){
        if(Double.parseDouble(tF1.getText()) != 0){
           tF2.clear();
            Double mile = Double.parseDouble(tF1.getText());
            Double kMCalculate = mile * 1.6023;
            tF2.setText(String.valueOf(kMCalculate));

        } else if(Double.parseDouble(tF2.getText())  != 0){
            tF1.clear();

            Double km = Double.parseDouble(tF2.getText());
            Double mileCalculate = km / 1.6023;
            tF1.setText(String.valueOf(  mileCalculate));
        }
    }

}
