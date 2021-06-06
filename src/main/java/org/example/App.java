package org.example;

import java.text.DecimalFormat;
import java.util.Scanner;

public class App {
    public static void main(String[] args){
        Scanner numbers = new Scanner(System.in);
        System.out.print("What is the order amount? ");
        String money = numbers.nextLine();
        System.out.print("What state do you live in? ");
        String state = numbers.nextLine();


        double m = Double.parseDouble(money);
        //for the string in the output
        int words = 0;
        double tax = 0;
        String taxes = "";
        String taxline = "";
        String taxend = "";
        DecimalFormat df = new DecimalFormat("#.00");

        if(state.matches("Wisconsin")){
            System.out.print("What county do you live in? ");
            String county = numbers.nextLine();
            words = 1;
            if(county.matches("Eau Claire")){
            tax = m * .055;
            //gets the double in the correct format
            tax = Double.valueOf(df.format(tax));
            taxes = Double.toString(tax);
            }
            else if(county.matches("Dunn")){
                tax = m * .054;
                tax = Double.valueOf(df.format(tax));
                taxes = Double.toString(tax);
            }
            else{
                tax = m * .05;
                tax = Double.valueOf(df.format(tax));
                taxes = Double.toString(tax);
            }
        }
        else if(state.matches("Illinois")){
            words = 1;
            tax = m * .08;
            tax = Double.valueOf(df.format(tax));
            taxes = Double.toString(tax);
        }

        //To add the tax if there is any
        if(words == 1){
            taxline = "The tax is $";
            taxend = ".\n";
        }
        double total = m + tax;

        System.out.println(taxline + taxes + taxend + "The total is $" + df.format(total) + ".");
    }
}
