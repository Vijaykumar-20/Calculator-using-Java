package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorFunctions {
    public static long Addition(long first,long second){
        try {
            long result= first + second;
            return result;
        }
        catch(Exception e){
            System.out.println("Invalid input." + e.getMessage());
        }
        return 0;
    }
    public static long Subtraction(long first,long second){
        try {
            long result= first - second;
            return result;
        }
        catch(Exception e){
            System.out.println("Invalid input." + e.getMessage());
        }
        return 0;
    }
    public static double Division(long first,long second){
        try {
            double result= (double)first /(double) second;
            return result;
        }
        catch(Exception e){
            System.out.println("Invalid input." + e.getMessage());
        }
        return 0;
    }
    public static long Multiplication(long first,long second){
            try {
                long result= first * second;
                return result;
            }
            catch(Exception e){
                System.out.println("Invalid input." + " " +  e.getMessage());
            }
            return 0;
    }
    public static double Percentage(long first,long second){
        try {
            double result= ((double)first /(double) 100 )*(double) second;
            return result;
        }
        catch(Exception e){
            System.out.println("Invalid input." + e.getMessage());
        }
        return 0;
    }

}
