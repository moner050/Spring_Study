package com.example.springcalculator.component;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Calculator {

    private final ICalculator iCalculator;

    public int sum(int x, int y)
    {   // 서버로부터 시세 정보를 받아와서 계산하라
        this.iCalculator.init();
        return this.iCalculator.sum(x, y);
    }

    public int minus(int x, int y)
    {
        this.iCalculator.init();
        return this.iCalculator.minus(x, y);
    }
}
