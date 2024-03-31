package com.ui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ComboBoxDemo extends Application {
    String[]flagTitle = {"Canada","China"}; //1
/*
    File file1 = new File("E:\\Study_coding\\IDEA_workspace\\Image\\canada.jpg");
    String url1 = file1.toURI().toString();
    Image image1 = new Image(url1);
    double width = image1.getWidth();
    double height = image1.getHeight();
*/
    ImageView[] flagImage = {
            new ImageView("image/ca.gif"),
            new ImageView("image/china.gif")
};

    String[] flagDescription = new String[2]; // 3

    DescriptionPane descriptionPane = new DescriptionPane();
    ComboBox<String> cbo = new ComboBox<>();
    @Override
    public void start(Stage primary){

        flagDescription[0] = "Canada..."; // give value to array[]
        flagDescription[1] = "China...";

    setDisplay(0); // default using the method created in the bottom
        //ComboBox<String> cbo = new ComboBox<>();
        ObservableList<String> items = FXCollections.observableArrayList(flagTitle);//
        cbo.getItems().addAll(items);

        BorderPane pane = new BorderPane(); //main borderPane
        pane.setPadding(new Insets(10));
        //HBox is also a substitute
        BorderPane borderPaneCombo = new BorderPane(); // the borderPane on the top of main pane
        borderPaneCombo.setPadding(new Insets(5,5,5,20));
        borderPaneCombo.setLeft(new Label("Select a country: "));
        borderPaneCombo.setCenter(cbo);

        pane.setTop(borderPaneCombo);
        pane.setCenter(descriptionPane); // the borderPane on the center of main pane
        cbo.setValue("Canada");
        cbo.setPrefWidth(400);

        cbo.setOnAction( e-> setDisplay(items.indexOf(cbo.getValue())));

        Scene scene = new Scene(pane);
        primary.setScene(scene);
        primary.setTitle("ComBoxDemo");
        primary.show();
    }
    public void setDisplay(int index){
        descriptionPane.setTitle(flagTitle[index]); // give value to label in DescriptionPane
        descriptionPane.setImageView(flagImage[index]); // give value to label in DescriptionPane
        descriptionPane.setDescription(flagDescription[index]);
    }
}
