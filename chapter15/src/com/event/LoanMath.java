package com.event;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoanMath extends Application {
    // As Textfield will be used outside method start(), leave them outside
    TextField tfAnnualIntR = new TextField();
    TextField tfNOfYear = new TextField();
    TextField tfLoanAmount = new TextField();
    TextField tfMonthlyPayment = new TextField();
    TextField tfTotalPayment = new TextField();
    Button btCalculate = new Button("Calculate");
    public void start(Stage primaryStage){
      //  Pane gridPane = new GridPane(); // under type Pane or GridPane the instance gets access to different methods
        GridPane gridPane = new GridPane();
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.add(new Label("Annual interest rate: "), 0, 0);
        gridPane.add(tfAnnualIntR, 1,0);
        gridPane.add(new Label("Num of years: "), 0, 1);
        gridPane.add(tfNOfYear,1,1);
        gridPane.add(new Label("Loan amount: "),0,2);
        gridPane.add(tfLoanAmount,1,2);
        gridPane.add(new Label("Monthly payment: "),0,3);
        gridPane.add(tfMonthlyPayment,1,3);
        gridPane.add(new Label("Total Payment: "),0,4);
        gridPane.add(tfTotalPayment,1,4);
        gridPane.add(btCalculate,1,5);

        // set properties
        gridPane.setAlignment(Pos.CENTER);
        tfAnnualIntR.setAlignment(Pos.BOTTOM_RIGHT);
        tfLoanAmount.setAlignment(Pos.BOTTOM_RIGHT);
        tfMonthlyPayment.setAlignment(Pos.BOTTOM_RIGHT);
        tfNOfYear.setAlignment(Pos.BOTTOM_RIGHT);
        tfTotalPayment.setAlignment(Pos.BOTTOM_RIGHT);
        tfMonthlyPayment.setEditable(false);
        tfTotalPayment.setEditable(false);
        GridPane.setHalignment(btCalculate, HPos.RIGHT); // static method
        // BoardPane.setAlignment(hBox, Pos.CENTRE)

        Scene scene = new Scene(gridPane);
        primaryStage.setTitle("loan payment demo");
        primaryStage.setScene(scene);
        primaryStage.show();

        // process events
        btCalculate.setOnAction(e ->{ calculateLoanPayment();

        });
    }
    private void calculateLoanPayment(){
        double interest = Double.parseDouble(tfAnnualIntR.getText());
        int year = Integer.parseInt(tfNOfYear.getText());
        double principal = Double.parseDouble(tfLoanAmount.getText());

        Loan1 loan = new Loan1(interest,year,principal);

        double totalPayment = loan.calculate();
        double monthPayment = totalPayment / (12 * year);
        tfMonthlyPayment.setText(String.format("%.2f", monthPayment));
        tfTotalPayment.setText(String.format("%.2f", totalPayment));

    }

}
class Loan1 {
    double interest;
    int year;
    double principal;
    public Loan1(){

    }
    public Loan1(double interest, int year, double principal){
        this.interest = interest;
        setYear(year);
        setPrincipal(principal);

    }
    double getInterest(){
        return interest;
    }
    void setInterest( double interest){
        this.interest = interest;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    public double getPrincipal(){
        return principal;
    }

    public void setPrincipal(double principal) {
        this.principal = principal;
    }
    public double calculate(){
        return Math.pow((principal * (1 + interest)) , year);
    }
}
