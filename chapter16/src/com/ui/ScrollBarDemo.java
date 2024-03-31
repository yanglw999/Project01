package com.ui;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ScrollBarDemo extends Application {
    @Override
    public void  start(Stage PrimaryStage){
        Text text = new Text(100, 100, "Happy New Year! ^-^");
        text.setFill(new Color(.6,.3,.2, .9));
        text.setFont(Font.font("New Roman", FontWeight.BOLD, FontPosture.ITALIC, 24));

       // ScrollPane spHorizontal = new ScrollPane(); not ScrollPane but ScrollBar
        ScrollBar sbHorizontal = new ScrollBar();
        ScrollBar sbVertical = new ScrollBar();
        sbHorizontal.setOrientation(Orientation.HORIZONTAL);
        sbHorizontal.setBlockIncrement(8);
        sbHorizontal.setVisibleAmount(10);
        sbVertical.setOrientation(Orientation.VERTICAL);

        Pane paneForText = new Pane(text);
        BorderPane borderPane = new BorderPane(); // it's BorderPane instead of BoardPane
        borderPane.setCenter(paneForText);
        borderPane.setBottom(sbHorizontal);
        borderPane.setRight(sbVertical);

        sbHorizontal.valueProperty().addListener( ov ->{
                 text.setX(sbHorizontal.getValue() / sbHorizontal.getMax() * paneForText.getWidth());
        });

        sbVertical.valueProperty().addListener(ov ->{
                text.setY(sbVertical.getValue() / sbVertical.getMax() * paneForText.getHeight() );
        });

        Scene scene = new Scene(borderPane);
        PrimaryStage.setScene(scene);
        PrimaryStage.setTitle("ScrollBar Demo");
        PrimaryStage.show();

    }
}
