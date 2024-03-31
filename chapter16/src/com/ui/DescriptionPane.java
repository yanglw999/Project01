package com.ui;

import javafx.geometry.Insets;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

public class DescriptionPane extends BorderPane {
    private Label labelTitle = new Label();
    TextArea textArea = new TextArea();

    DescriptionPane(){
        setPadding(new Insets(20,40,30,50));
        labelTitle.setContentDisplay(ContentDisplay.TOP);
        labelTitle.setPrefSize(200,100);
        labelTitle.setFont(new Font("SansSerif",16));

        textArea.setFont( Font.font("Serif",14));
        textArea.setWrapText(true);
        textArea.setEditable(false);

        ScrollPane scrollPane = new ScrollPane(textArea);

        // place label and scrollPane in the borderPane
        setLeft(labelTitle);
        setCenter(scrollPane);
        setPadding(new Insets(5));
    }
    public void setTitle(String title){
        labelTitle.setText(title);
    }
    public void setImageView(ImageView icon){
        labelTitle.setGraphic(icon);    // label.setGraphic();
    }
    public void setDescription(String text){
        textArea.setText(text);
    }
}
