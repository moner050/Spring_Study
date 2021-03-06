package com.spring.jpa.test.JpaTest.domain.converter;


import com.spring.jpa.test.JpaTest.domain.dto.BookStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;

@Convert
public class BookStatusConverter implements AttributeConverter<BookStatus, Integer> {
    @Override
    public Integer convertToDatabaseColumn(BookStatus attribute)
    {
        return attribute.getCode();
    }

    @Override
    public BookStatus convertToEntityAttribute(Integer dbData)
    {
        return dbData != null ? new BookStatus(dbData) : null;
    }

}
