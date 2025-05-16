package com.app.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    //method to add the inputs
    public double add(double a, double b) {
        return a+b;
    }

    //method to subtract the input values
    public double sub(double a, double b) {
        return a-b;
    }

    //method to multiple two inputs
    public double mult(double a, double b) {
        return a*b;
    }

    //method to divide two inputs and prevent division by zero
    public double div(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by Zero");
        }
        return a/b;
    }

    //method to return the modulous of two input numbers
    public double mod(double a, double b) {
        return a%b;
    }
}