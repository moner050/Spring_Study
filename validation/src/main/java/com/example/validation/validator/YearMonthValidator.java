package com.example.validation.validator;

import com.example.validation.annotation.YearMonth;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class YearMonthValidator implements ConstraintValidator<YearMonth, String> {

    private String pattern;

    // 어노테이션이 지정된 패턴을 가지고 와서
    @Override
    public void initialize(YearMonth constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();
    }

    // 패턴이 맞나 검사후 boolean 값 리턴
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        System.out.println("동작확인");
        // yyyy mm dd
        try
        {
            LocalDate localDate = LocalDate.parse(value + "11", DateTimeFormatter.ofPattern(this.pattern));
        }
        catch(Exception e)
        {
            return false;
        }

        return true;
    }
}
