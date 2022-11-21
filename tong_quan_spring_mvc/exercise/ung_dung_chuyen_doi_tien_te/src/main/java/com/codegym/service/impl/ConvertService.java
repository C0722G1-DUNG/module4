package com.codegym.service.impl;

import com.codegym.service.IConvertService;
import org.springframework.stereotype.Service;

@Service
public class ConvertService implements IConvertService {
    @Override
    public double convertvnd(double usd) {
        return usd*23000;
    }

    @Override
    public double convertusd(double vnd) {
        return vnd/23000;
    }
}
