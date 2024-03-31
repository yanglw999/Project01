package com.event;

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

public class LoanCalculator extends Application {
    TextField intRate = new TextField();
    TextField numOfYears = new TextField();
    TextField loanAmount = new TextField();
    TextField monthPayment = new TextField();
    TextField totalPayment = new TextField();
    @Override
    public void start(Stage Primary){

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(5));
        gridPane.setAlignment(Pos.CENTER);// the position of whole pane in the scene
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        gridPane.add(new Label("Annual Int Rate:"),0,0);
        gridPane.add(intRate,1,0);
        gridPane.add(new Label("Num of Years:"),0,1);
        gridPane.add(numOfYears,1,1);
        gridPane.add(new Label("Loan Amount:"),0,2);
        gridPane.add(loanAmount,1,2);
        gridPane.add(new Label("Monthly Payment:"),0,3);
        gridPane.add(monthPayment,1,3);
        gridPane.add(new Label("Total Payment:"),0,4);
        gridPane.add(totalPayment,1,4);
        Button button = new Button("Calculate");
        gridPane.add(button,1,5);
        GridPane.setHalignment(button, HPos.RIGHT);//the position of button

        intRate.setAlignment(Pos.BASELINE_RIGHT);// input text position
        numOfYears.setAlignment(Pos.BASELINE_RIGHT);
        loanAmount.setAlignment(Pos.BASELINE_RIGHT);
        monthPayment.setAlignment(Pos.BASELINE_RIGHT);
        totalPayment.setAlignment(Pos.BASELINE_RIGHT);
        monthPayment.setEditable(false);//
        totalPayment.setEditable(false);//
        button.setOnAction(e -> calculateLoanPayment());

        Scene scene = new Scene(gridPane);
        Primary.setScene(scene);
        Primary.setTitle("Loan Calculator");
        Primary.show();
    }
    private void calculateLoanPayment(){
        double interest = Double.parseDouble(intRate.getText());
        int year = Integer.parseInt(numOfYears.getText().trim());
        double principal = Double.parseDouble(loanAmount.getText());// getText()
        Loan loan = new Loan(interest,principal,year);
        monthPayment.setText(String.format("%.2f",loan.getMonthPayment()));//setText()
        totalPayment.setText(String.format("%.2f",loan.getTotalPayment()));

    }
}
class Loan{
    double intRate, loanAmount, nOfY ;
    public Loan(double intRate, double loanAmount, double nOfY){
        this.intRate = intRate;
        this.loanAmount = loanAmount;
        this.nOfY = nOfY;
    }
    public double getMonthPayment(){
        return loanAmount / (Math.pow(1 + intRate/100/12, nOfY*12)-1) *
                (intRate/100/12 * (Math.pow(1 + intRate/100/12 , nOfY * 12)));
    }
    public double getTotalPayment(){
        return getMonthPayment() * nOfY * 12;
    }
}