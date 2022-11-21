package com.computer.controller.service;

import org.springframework.stereotype.Service;

@Service
public class ComputerService implements IComputerService {
    @Override
    public double addition(double numberOne, double numberTwo) {

        return numberOne+numberTwo;
    }

    @Override
    public double subtraction(double numberOne, double numberTwo) {
        return numberOne-numberTwo;
    }

    @Override
    public double multiplication(double numberOne, double numberTwo) {
        return numberOne*numberTwo;
    }

    @Override
    public double division(double numberOne, double numberTwo) {
        return numberOne/numberTwo;
    }
}
