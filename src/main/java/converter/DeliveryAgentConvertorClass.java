package converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;

public class DeliveryAgentConvertorClass implements AttributeConverter<DeliveryAgentConvertorClass, String> {

    private static ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();

    }

    @Override
    public String convertToDatabaseColumn(DeliveryAgentConvertorClass attribute) {
        try {
            return mapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    @Override
    public DeliveryAgentConvertorClass convertToEntityAttribute(String dbData) {
        try {
            return mapper.readValue(dbData, new TypeReference<DeliveryAgentConvertorClass>() {
            });
        } catch (Exception e) {
            return null;
        }
    }

}