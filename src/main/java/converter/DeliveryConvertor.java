package converter;

import com.example.famto.entity.OrderDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import java.util.List;


public class DeliveryConvertor implements AttributeConverter<List<OrderDetails>, String> {

    private static ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();

    }

    @Override
    public String convertToDatabaseColumn(List<OrderDetails> attribute) {
        try {
            return mapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    @Override
    public List<OrderDetails> convertToEntityAttribute(String dbData) {
        try {
            return mapper.readValue(dbData, new TypeReference<List<OrderDetails>>() {
            });
        } catch (Exception e) {
            return null;
        }
    }

}