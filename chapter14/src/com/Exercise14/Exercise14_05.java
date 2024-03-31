package com.fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise14_05 extends Application {
    @Override
    public void start(Stage primaryStage){
        Pane pane = new Pane();
        double radius = 80;
        String str = " WELCOME TO JAVA";
        char[] chars = getCharsArray(str);
        Text text;
        Font font =  Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC,35);
        for(int i = 0; i < str.length(); i++){
            double alpha = 2 * Math.PI / str.length() * ( str.length() - i);
            text = new Text(radius * Math.cos(alpha) + 120,
                    120 - radius * Math.sin(alpha),chars[i] + "");
            text.setRotate(360.0 * i / str.length() + 90);
            text.setFont(font);
            pane.getChildren().add(text);
        }
        Scene scene = new Scene(pane,240,240);
        primaryStage.setScene(scene);
        primaryStage.setTitle("show Circled String");
        primaryStage.show();


    }
    public static char[] getCharsArray(String str){
        char[] chars = new char[str.length()];
        for(int i = 0; i < str.length(); i++){
            chars[i] = str.charAt(i);
        }
        return chars;
    }


}
