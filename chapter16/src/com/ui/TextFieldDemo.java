package com.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class TextFieldDemo extends RadioButtonDemo {
    @Override
    protected BorderPane getPane(){
        BorderPane pane = super.getPane();

        BorderPane paneTextField = new BorderPane();
        paneTextField.setPadding(new Insets(5));
        paneTextField.setStyle("-fx-border-color: GREEN");
        paneTextField.setLeft(new Label("Enter a new message: "));

        TextField textField = new TextField();
        textField.setAlignment(Pos.BOTTOM_RIGHT);

        paneTextField.setCenter(textField);
        pane.setTop(paneTextField);

        EventHandler<ActionEvent> eventHandler = e->{text.setText(textField.getText());};
        textField.setOnAction(eventHandler);

        return pane;
    }

    //Scene scene = new Scene(getPane());

}
