package com.fx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.Random;

public class Exercise14_03 extends Application {
    @Override
    public void start(Stage primaryStage){
        FlowPane flowPane = new FlowPane();
        flowPane.setAlignment(Pos.CENTER);
        flowPane.setHgap(20);
        flowPane.setVgap(20);
        for(int i = 0; i < 5; i++){
            flowPane.getChildren().add(getCard(i));
        }

        Scene scene = new Scene(flowPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("cards");
        primaryStage.show();
    }
    public static ImageView getCard(int i){
        int[] cards = getDistinctNums(52);
        ImageView view = new ImageView("card/" + cards[i] +".png");
        return view;

    }
    public static int[] getDistinctNums(int n){
        int[]nums = new int[n];
        int i = 0;
        while( i < n){
            Random random = new Random();
            int r = random.nextInt(52) + 1;
            boolean diff = true;
            for(int j = 0; j < i; j++){
                if(nums[j] == r){
                    diff = false;
                   break;
                }
            }
            if(diff){
                nums[i] = r;
                i++;
            }
        }
        return nums;
    }
}
