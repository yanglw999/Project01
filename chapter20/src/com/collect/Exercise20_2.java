package com.collect;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.*;

public class Exercise20_2 extends Application {
    NumList numList = new NumList();
    TextArea textArea = new TextArea();
    @Override
    public void start(Stage primaryStage){
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(5));

        HBox hBox1 = new HBox(10);
        hBox1.setAlignment(Pos.CENTER);
        TextField textField = new TextField();
        textField.setAlignment(Pos.CENTER);
        hBox1.getChildren().addAll(new Label("Enter a number: "), textField);

        HBox hBox2 = new HBox(25);
        hBox2.setAlignment(Pos.CENTER);
        Button btSort = new Button("Sort");
        Button btShuffle = new Button("Shuffle");
        Button btReverse = new Button("Reverse");
        hBox2.getChildren().addAll(btSort, btShuffle, btReverse);

        borderPane.setTop(hBox1);
        borderPane.setBottom(hBox2);

        textArea.setPrefRowCount(40);
        textArea.setPrefColumnCount(50);
        textArea.setWrapText(true);

        ScrollPane scrollPane = new ScrollPane(textArea);
        borderPane.setCenter(scrollPane);
        textField.setOnKeyPressed( e ->{
            if(e.getCode() == KeyCode.ENTER){
                textArea.appendText(textField.getText() + " "); //$$$$
                numList.add(Double.parseDouble(textField.getText()));
                textField.clear();
            }
        });

        btSort.setOnAction(e -> {
          textArea.clear();
            numList.sort(numList);
            display();});
        btShuffle.setOnAction(e -> {
            textArea.clear();
            numList.shuffle(numList);
            display();});
        btReverse.setOnAction(e -> {
            textArea.clear();
            numList.Reverse(numList);
            display();});

        Scene scene = new Scene(borderPane, 600,500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise20_2");
        primaryStage.show();
        textField.requestFocus();
    }
    public void display(){
        ListIterator<Number> listIterator = numList.listIterator();
        while (listIterator.hasNext()){
            textArea.appendText(listIterator.next() + " ");
        }
}
class NumList extends ArrayList<Number> {
    List<Number> list = new ArrayList<>();
    public NumList(){

    }
    public void sort(List list){
        list.sort(new NumComparator());
    }
    public void shuffle(List list){
        Collections.shuffle(list);
    }
    public void Reverse(List list){
       // Collections.reverse(list);
        list.sort(Comparator.comparing(Number::doubleValue).reversed());
    }

    }
}
class NumComparator implements Comparator<Number>{
    @Override
    public int compare(Number n1, Number n2){
        if(n1.doubleValue() > n2.doubleValue()){
            return 1;
        }else if(n1.doubleValue() == n2.doubleValue()){
            return 0;
        }else {
            return -1;
        }
    }
}