package com.example.springcalculator.component;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

@SpringBootTest
// SpringBootTest 를 붙히는 순간 모든 Bean 이 등록이 되어서 Import 를 시킬 필요가 없다.
//@Import({MarketApi.class, DollarCalculator.class})
public class DollarCalculatorTest {

    @MockBean
    private MarketApi marketApi;

    @Autowired
    private DollarCalculator dollarCalculator;

    @Test
    public void dollarCalculatorTest()
    {
        // marketApi에 connect가 일어날때 3000 리턴
        Mockito.when(marketApi.connect()).thenReturn(3000);
        dollarCalculator.init();

        int sum = dollarCalculator.sum(10, 10);
        int minus = dollarCalculator.minus(10, 10);

        Assertions.assertEquals(60000, sum);
        Assertions.assertEquals(0, minus);

    }

}
