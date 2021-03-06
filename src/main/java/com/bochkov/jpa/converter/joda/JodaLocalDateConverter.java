/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.bochkov.jpa.converter.joda;

import org.joda.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Date;

/**
 * Converts a Joda LocalDate <-> JPA 2.1 date
 * <p>
 * This one is a little tricky, so we utilize the Joda internal LocalDate to
 * Date functions to meet our requirements.
 */
@Converter(autoApply = true)
public class JodaLocalDateConverter implements AttributeConverter<Object, Date> {

    public Date convertToDatabaseColumn(Object dateValue) {
        if (dateValue == null) {
            return null;
        }
        if (dateValue instanceof LocalDate) {
            return((LocalDate) dateValue).toDate() ;
        }
        if (dateValue instanceof String) {
            return java.sql.Date.valueOf((String) dateValue);
        }
        return null;
    }

    public Object convertToEntityAttribute(Date date) {
        return date != null ? LocalDate.fromDateFields(date) : null;
    }
}
