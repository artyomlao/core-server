package core.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.NoArgsConstructor;

@Converter
@NoArgsConstructor
public class LongToBooleanConverter implements AttributeConverter<Boolean, Long> {

    public Long convertToDatabaseColumn(final Boolean value) {
        return value ? 1L : 0L;
    }

    public Boolean convertToEntityAttribute(final Long dbValue) {
        return dbValue == 1L;
    }
}