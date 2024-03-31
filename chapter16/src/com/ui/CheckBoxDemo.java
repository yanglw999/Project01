package com.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class CheckBoxDemo extends ButtonDemo {
    @Override //
    BorderPane getPane(){
        BorderPane borderPane = super.getPane(); // inherited text, bolderPnae

        Font fontBoldItalic = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20);
        Font fontBoldRegular = Font.font("Times New Rome",FontWeight.BOLD,FontPosture.REGULAR,20);
        Font fontNormalItalic = Font.font("Times New Rome", FontWeight.NORMAL,FontPosture.ITALIC,20);
        Font fontNormalRegular = Font.font("Times New Rome", FontWeight.NORMAL,FontPosture.REGULAR, 20);

        text.setFont(fontNormalRegular);

        VBox vBox = new VBox(40);
        vBox.setPadding(new Insets(15,5,5,15));
        vBox.setStyle("-fx-border-color: RED");

        CheckBox chkBold = new CheckBox("BOLD");
        CheckBox chkItalic = new CheckBox("ITALIC");
        vBox.getChildren().addAll(chkBold,chkItalic);
        vBox.setAlignment(Pos.CENTER);
        borderPane.setRight(vBox);

        EventHandler<ActionEvent> eventHandler = e ->{
            if(chkBold.isSelected()&& chkItalic.isSelected()){
                text.setFont(fontBoldItalic);
            }else if (chkBold.isSelected()){
                text.setFont(fontBoldRegular);
            } else if(chkItalic.isSelected()){
                text.setFont(fontNormalItalic);
            }else{
                text.setFont(fontNormalRegular);
            }
        };
        chkBold.setOnAction(eventHandler);
        chkItalic.setOnAction(eventHandler);
        return borderPane;
    }
   @Override
    public void start(Stage primary){
        Scene scene = new Scene(getPane());
        primary.setTitle("CheckBoxDemo");
        primary.setScene(scene);
        primary.show();

    }
}
