import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.File;

public class CheckBoxSubDemo extends Application {
    File file = new File("E:\\Study_coding\\IDEA_workspace\\Image","canada.jpg");
    String url = file.toURI().toString();
    //
    Image image1 = new Image(url);
    double width = image1.getWidth();
    double height = image1.getHeight();
    ImageView imageView1 = new ImageView(image1);

    @Override
    public  void start(Stage primaryStage){
        imageView1.setFitHeight(height * .053);
        imageView1.setFitWidth(width * .053);

        CheckBox chkUS = new CheckBox("US");
        chkUS.setFont(Font.font("NEW Roman", FontWeight.BOLD, FontPosture.ITALIC,20));
        chkUS.setTextFill(Color.color(.4,.3,.2));

        chkUS.setGraphic(imageView1);
        chkUS.setContentDisplay(ContentDisplay.RIGHT);
        chkUS.setSelected(true);
        chkUS.setPadding(new Insets(5));
        chkUS.setStyle("-fx-border-color: Green");
        chkUS.setGraphicTextGap(15);

        Pane pane = new Pane();
        pane.getChildren().add(chkUS);

        pane.widthProperty().addListener(ov -> chkUS.setPrefWidth(pane.getWidth() * .2));
        pane.heightProperty().addListener(ov -> chkUS.setPrefHeight(pane.getHeight() * .2 ));

        chkUS.layoutXProperty().bind(pane.widthProperty().divide(3));
        chkUS.layoutYProperty().bind(pane.heightProperty().divide(3));

        Scene scene = new Scene(pane);
        primaryStage.setTitle("CheckBox USA");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
