package com.allieduniversal.assessment.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Set;

@Converter
public class SetToStringConverter implements AttributeConverter<Set<String>, String> {

    private final static String SPLIT_CHAR = ";";

    @Override
    public String convertToDatabaseColumn(Set<String> strings) {
        return strings != null ? String.join(SPLIT_CHAR, strings) : "";
    }

    @Override
    public Set<String> convertToEntityAttribute(String string) {
        return string != null ? Set.of(string.split(SPLIT_CHAR)) : Set.of();
    }
}
