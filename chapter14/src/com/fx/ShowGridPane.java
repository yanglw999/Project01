package com.fx;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ShowGridPane extends Application {
    @Override
    public void start(Stage primary){
        //Pane can’t invoke setHgap() & setVgap(), so Pane can’t replace FlowPane or GridPane when creating the new object
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(11.2, 12.5,13.5,14.5));
        gridPane.setAlignment(Pos.CENTER);// set entire gridPane location
        gridPane.setHgap(5.5);
        gridPane.setVgap(5.5);
        gridPane.setGridLinesVisible(false);

        gridPane.add(new Label("First Name: "),0,0);
        gridPane.add(new TextField(),1,0);
        gridPane.add(new Label("MI: "),0,1);
        gridPane.add(new TextField(),1,1);
        gridPane.add(new Label("Last Name: "),0,2);
        gridPane.add(new TextField(),1,2);
        Button buttonAdd = new Button("Add Name");
        gridPane.add(buttonAdd,1,3);
        //
        GridPane.setHalignment(buttonAdd, HPos.RIGHT);// align button right, static method, set a particular ceil
        Scene scene = new Scene(gridPane);
        primary.setTitle("Show GridPane");
        primary.setScene(scene);
        primary.show();
    }

    public static void main(String[] args) {
        Application.launch();
    }
}
