package com.ui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Exercise16_16 extends Application {

    ComboBox<String> cboSelectionModel = new ComboBox<>();
    String[] countries = {"China","Japan","Korea","India","Malaysia","Vietnam","Singapore","Thailand"};
    ObservableList<String> obList = FXCollections.observableArrayList(countries);
    ListView<String> lvCountry = new ListView<>(obList); //$$$
    Label displayLabel = new Label();

    @Override
    public void start(Stage primaryStage){
        //lvCountry.getItems().add(String.valueOf(obList));
        cboSelectionModel.getItems().addAll("MULTIPLE","SINGLE");
        cboSelectionModel.setValue("SINGLE");
        HBox hBox1 = new HBox(10);
        hBox1.setAlignment(Pos.CENTER);
        hBox1.getChildren().addAll(new Label("Choose selection Model: "),cboSelectionModel);

        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(5));
        borderPane.setTop(hBox1);

        lvCountry.setOrientation(Orientation.VERTICAL);
        borderPane.setCenter(lvCountry);

        borderPane.setBottom(displayLabel);

        Scene scene = new Scene(borderPane, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise16_16");
        primaryStage.show();

        lvCountry.getSelectionModel().selectedItemProperty().addListener( ov -> setSelection());
        cboSelectionModel.setOnAction( e -> setSelection());
    }
    private void setSelection(){
        StringBuilder items = new StringBuilder(" ");
        if(cboSelectionModel.getValue().equals("MULTIPLE")){
            lvCountry.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        }else{
            lvCountry.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        }

        for(Integer i :   lvCountry.getSelectionModel().getSelectedIndices()){ //$$$$
            items = items.append(countries[i] + " ");

        }
        // another method
        /* for(String s : lvCountry.getSelectionModel().getSelectedItems()){

        } */
        displayLabel.setText(String.valueOf(items));
    }
}
