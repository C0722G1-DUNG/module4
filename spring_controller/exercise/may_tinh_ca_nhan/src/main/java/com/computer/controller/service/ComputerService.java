package com.computer.controller.service;

import org.springframework.stereotype.Service;

@Service
public class ComputerService implements IComputerService {
    @Override
    public double calculate(double numberOne, double numberTwo, String choise) {
        double calculate = 0;
        switch (choise){
            case "Addition(+)":
                calculate= numberOne+numberTwo;
                break;
            case "Subtraction(-)":
                calculate = numberOne - numberTwo;
                break;
            case "Multiplication(x)":
                calculate=  numberOne*numberTwo;
                break;
            case "Division(/)":
                if (numberOne==0||numberTwo==0){
                   throw new ArithmeticException("không đc khóc");
                }else
                calculate=  numberOne/ numberTwo;
                break;
        }
        return calculate;
    }
//    @Override
//    public double addition(double numberOne, double numberTwo) {
//
//        return numberOne+numberTwo;
//    }
//
//    @Override
//    public double subtraction(double numberOne, double numberTwo) {
//        return numberOne-numberTwo;
//    }
//
//    @Override
//    public double multiplication(double numberOne, double numberTwo) {
//        return numberOne*numberTwo;
//    }
//
//    @Override
//    public double division(double numberOne, double numberTwo) {
//        return numberOne/numberTwo;
//    }

}
