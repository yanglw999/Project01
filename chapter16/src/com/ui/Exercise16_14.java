package com.ui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Exercise16_14 extends Application {
    @Override
    public void start(Stage primaryStage){
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10));
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);

        ComboBox<String> comboBoxFont = new ComboBox<>();
        ObservableList<String> fonts = FXCollections.observableArrayList(Font.getFamilies());
        comboBoxFont.getItems().addAll(fonts);
        comboBoxFont.setValue(fonts.get(0));

        ComboBox<String> comboBoxSize = new ComboBox<>();
        String[] nums = new String[100];
        for(int i = 0; i < nums.length; i++){
            nums[i] = String.valueOf(i + 1) ;
        }
        ObservableList<String > size =  FXCollections.observableArrayList(nums);
        comboBoxSize.getItems().addAll(size);
        comboBoxSize.setValue(size.get(0));

        hBox.getChildren().addAll(new Label("Font Name: "), comboBoxFont, new Label("Font Size: "), comboBoxSize);
        borderPane.setTop(hBox);

        TextField textField = new TextField();
       // textField.setPrefColumnCount(10);
        borderPane.setCenter(textField);

        comboBoxFont.setOnAction( e ->{
            textField.setFont(Font.font(comboBoxFont.getValue()));
        });
        comboBoxSize.setOnAction( e ->
                textField.setFont(Font.font(Double.parseDouble(comboBoxSize.getValue()))));

        CheckBox chxBold = new CheckBox("Bold");
        CheckBox chxItalic = new CheckBox("Italic");
        HBox hBox1 = new HBox(10);
        hBox1.getChildren().addAll(chxBold,chxItalic);
        hBox1.setAlignment(Pos.CENTER);
        borderPane.setBottom(hBox1);

        Font fontBoldItalic = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC,20);
        Font fontBold = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR,20);
        Font fontItalic = Font.font("Times New Roman", FontWeight.NORMAL,FontPosture.ITALIC,20);
        Font fontNormal = Font.font("Times New Roman",FontWeight.NORMAL,FontPosture.REGULAR,20);

        EventHandler<ActionEvent> eventHandler = e ->{
            if(chxBold.isSelected() && chxItalic.isSelected()){
                textField.setFont(fontBoldItalic);
            } else if(chxBold.isSelected()){
                textField.setFont(fontBold);
            } else if(chxItalic.isSelected()){
                textField.setFont(fontItalic);
            } else {
                textField.setFont(fontNormal);
            }
        };

        chxBold.setOnAction(eventHandler);
        chxItalic.setOnAction(eventHandler);

        Scene scene = new Scene(borderPane, 800, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise16_14");
        primaryStage.show();







    }
}
