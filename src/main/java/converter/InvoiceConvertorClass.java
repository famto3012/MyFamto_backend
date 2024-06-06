package converter;


import com.example.famto.entity.InvoiceModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;

public class InvoiceConvertorClass implements AttributeConverter<InvoiceModel, String> {

    private static ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();

    }

    @Override
    public String convertToDatabaseColumn(InvoiceModel attribute) {
        try {
            return mapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    @Override
    public InvoiceModel convertToEntityAttribute(String dbData) {
        try {
            return mapper.readValue(dbData, new TypeReference<InvoiceModel>() {
            });
        } catch (Exception e) {
            return null;
        }
    }

}