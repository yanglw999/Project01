package Exercise15;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Calculator extends Application {
    TextField textField1 = new TextField();
    TextField textField2 = new TextField();
    TextField textField3 = new TextField();

    Button b0 = new javafx.scene.control.Button("0");
    Button b1 = new javafx.scene.control.Button("1");
    Button b2= new javafx.scene.control.Button("2");
    Button b3= new javafx.scene.control.Button("3");
    Button b4= new javafx.scene.control.Button("4");
    Button b5= new javafx.scene.control.Button("5");
    Button b6= new javafx.scene.control.Button("6");
    Button b7= new javafx.scene.control.Button("7");
    Button b8= new javafx.scene.control.Button("8");
    Button b9= new javafx.scene.control.Button("9");
    Button bDot = new javafx.scene.control.Button(".");
    Button bEqual = new javafx.scene.control.Button("=");
    RadioButton r1 = new RadioButton("+");
    RadioButton r2 = new RadioButton("-");
    RadioButton r3 = new RadioButton("*");
    RadioButton r4 = new RadioButton("/");
    RadioButton r5 = new RadioButton("clean");

    ArrayList<Button> buttons = new ArrayList<>();
    StringBuilder str1 = new StringBuilder("");
    StringBuilder str2 = new StringBuilder();
    Double answer;

    @Override
    public void start(Stage primaryStage){
        BorderPane borderPane = new BorderPane();

        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(textField1,textField2,textField3);
        textField1.setAlignment(Pos.BASELINE_RIGHT);
        textField2.setAlignment(Pos.BASELINE_RIGHT);
        textField3.setAlignment(Pos.BASELINE_RIGHT);
        borderPane.setTop(hBox);

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(5));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);
            ArrayList<Button> buttons = new ArrayList<>();
            buttons.add(b0);buttons.add(b1);buttons.add(b2);
            buttons.add(b3);buttons.add(b4);buttons.add(b5);
            buttons.add(b6);buttons.add(b7);buttons.add(b8);
            buttons.add(b9);buttons.add(bDot);buttons.add(bEqual);

            ToggleGroup group = new ToggleGroup();
        r1.setToggleGroup(group);
        r2.setToggleGroup(group);
        r3.setToggleGroup(group);
        r4.setToggleGroup(group);
        r5.setToggleGroup(group);

        gridPane.add(r1,3,0);
        gridPane.add(r2,3,1);
        gridPane.add(r3,3,2);
        gridPane.add(r4,3,3);
        hBox.getChildren().add(r5);

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 3; j++){
                gridPane.add(buttons.get((i * 3 + j)),j,i);
            }
        }
        // button 0
        b0.setOnAction(e -> {
            if(r1.isSelected()||r2.isSelected()||r3.isSelected()||r4.isSelected()){
                str2.append("0");
                textField2.setText(str2 + "");
            }else {
                str1.append("0");
                textField1.setText(str1 + "");
            }
        });
        // button 1
        b1.setOnAction(e -> {
            if(r1.isSelected()||r2.isSelected()||r3.isSelected()||r4.isSelected()){
                str2.append(String.valueOf(1));
                textField2.setText(str2 + "");
            }else {
                str1.append(String.valueOf(1));
                textField1.setText(str1 + "");
            }
        });
        b2.setOnAction(e -> {
            if(r1.isSelected()||r2.isSelected()||r3.isSelected()||r4.isSelected()){
                str2.append(String.valueOf(2));
                textField2.setText(str2 + "");
            }else {
                str1.append(String.valueOf(2));
                textField1.setText(str1 + "");
            }
        });
        b3.setOnAction(e -> {
            if(r1.isSelected()||r2.isSelected()||r3.isSelected()||r4.isSelected()){
                str2.append(String.valueOf(3));
                textField2.setText(str2 + "");
            }else {
                str1.append(String.valueOf(3));
                textField1.setText(str1 + "");
            }
        });
        b4.setOnAction(e -> {
            if(r1.isSelected()||r2.isSelected()||r3.isSelected()||r4.isSelected()){
                str2.append(String.valueOf(4));
                textField2.setText(str2 + "");
            }else {
                str1.append(String.valueOf(4));
                textField1.setText(str1 + "");
            }
        });
        b5.setOnAction(e -> {
            if(r1.isSelected()||r2.isSelected()||r3.isSelected()||r4.isSelected()){
                str2.append(String.valueOf(5));
                textField2.setText(str2 + "");
            }else {
                str1.append(String.valueOf(5));
                textField1.setText(str1 + "");
            }
        });
        b6.setOnAction(e -> {
            if(r1.isSelected()||r2.isSelected()||r3.isSelected()||r4.isSelected()){
                str2.append(String.valueOf(6));
                textField2.setText(str2 + "");
            }else {
                str1.append(String.valueOf(6));
                textField1.setText(str1 + "");
            }
        });
        b7.setOnAction(e -> {
            if(r1.isSelected()||r2.isSelected()||r3.isSelected()||r4.isSelected()){
                str2.append(String.valueOf(7));
                textField2.setText(str2 + "");
            }else {
                str1.append(String.valueOf(7));
                textField1.setText(str1 + "");
            }
        });

        b8.setOnAction(e -> {
            if(r1.isSelected()||r2.isSelected()||r3.isSelected()||r4.isSelected()){
                str2.append(String.valueOf(8));
                textField2.setText(str2 + "");
            }else {
                str1.append(String.valueOf(8));
                textField1.setText(str1 + "");
            }
        });
        b9.setOnAction(e -> {
            if(r1.isSelected()||r2.isSelected()||r3.isSelected()||r4.isSelected()){
                str2.append(String.valueOf(9));
                textField2.setText(str2 + "");
            }else {
                str1.append(String.valueOf(9));
                textField1.setText(str1 + "");
            }
        });
        bDot.setOnAction(e -> {
            if(r1.isSelected()||r2.isSelected()||r3.isSelected()||r4.isSelected()){
                str2.append(String.valueOf('.'));
                textField2.setText(str2 + "");
            }else {
                str1.append(String.valueOf('.'));
                textField1.setText(str1 + "");
            }
        });

        bEqual.setOnAction( e -> calculate());
        r5.setOnAction( e -> clean());

        borderPane.setCenter(gridPane);
        bEqual.setTextFill(Color.RED);
        Scene scene = new Scene(borderPane, 600,400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Calculator");
        primaryStage.show();
    }
    private void clean(){
       if(r5.isSelected()){
           str1.delete(0,str1.length());
           str2.delete(0,str2.length());
           textField1.clear();
           textField2.clear();
           textField3.clear();

       }
    }

    private void calculate(){
        Double n1 = Double.parseDouble(textField1.getText());
        Double n2 = Double.parseDouble(textField2.getText());

        if(r1.isSelected()){
            answer = n1  + n2;
        }else if(r2.isSelected()){
            answer = n1 - n2;
        }else if(r3.isSelected()){
            answer = n1 * n2;
        }else if(r4.isSelected()){
            answer = n1 / n2;
        }

        textField3.setText(answer + "");
    }
}
