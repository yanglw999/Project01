package com.ui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class Exercise16_14B extends Application {
    private ComboBox<String> comboBoxFont = new ComboBox<>();
    private ComboBox<Integer> comboBoxSize = new ComboBox<>();
    private TextField textField = new TextField();
    private CheckBox chxBold = new CheckBox("Bold");
    private CheckBox chxItalic = new CheckBox("Italic");
    @Override
    public void start(Stage primaryStage){
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10));
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);

        ObservableList<String> fonts = FXCollections.observableArrayList(Font.getFamilies());
        comboBoxFont.getItems().addAll(fonts);
        comboBoxFont.setValue(fonts.get(0));

        for(int i = 1; i <= 100; i++){
             comboBoxSize.getItems().add(i) ;
        }
        comboBoxSize.setValue(1);

        hBox.getChildren().addAll(new Label("Font Name: "), comboBoxFont, new Label("Font Size: "), comboBoxSize);
        borderPane.setTop(hBox);

        // textField.setPrefColumnCount(10);
        borderPane.setCenter(textField);

        HBox hBox1 = new HBox(10);
        hBox1.getChildren().addAll(chxBold,chxItalic);
        hBox1.setAlignment(Pos.CENTER);
        borderPane.setBottom(hBox1);


        Scene scene = new Scene(borderPane, 800, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise16_14");
        primaryStage.show();

        comboBoxFont.setOnAction( e ->{
            // textField.setFont(Font.font(comboBoxFont.getValue()));
            setFont();
        });
        comboBoxSize.setOnAction( e ->
                // textField.setFont(comboBoxSize.getValue()
                setFont()
        );
        chxBold.setOnAction( e ->
                setFont());

        chxItalic.setOnAction( e -> setFont());

    }
    // non-static method
    private void setFont(){ // the method outside of star() is allowed to be non-static
        FontPosture posture;
        FontWeight weight;
        if(chxItalic.isSelected()){
            posture = FontPosture.ITALIC;
        }else {
            posture = FontPosture.REGULAR;
        }

        if(chxBold.isSelected()){
            weight = FontWeight.BOLD;
        }else {
            weight = FontWeight.NORMAL;
        }
        textField.setFont(Font.font(comboBoxFont.getValue(),weight,posture,comboBoxSize.getValue()));
    }
}
