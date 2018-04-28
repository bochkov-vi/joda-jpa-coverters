package com.bochkov.jpa.converter.joda;

import org.joda.time.DateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Date;

/**
 * Joda DateTime <-> JPA 2.1 converter
 */
@Converter(autoApply = true)
public class JodaDateTimeConverter implements AttributeConverter<DateTime, Date> {

    public Date convertToDatabaseColumn(DateTime dateTime) {
        return dateTime != null ? dateTime.toDate() : null;
    }

    public DateTime convertToEntityAttribute(Date date) {
        return date != null ? new DateTime(date) : null;
    }
}
