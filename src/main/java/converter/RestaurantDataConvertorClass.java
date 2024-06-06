package converter;


import com.example.famto.entity.RestaurantData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;

public class RestaurantDataConvertorClass implements AttributeConverter<RestaurantData, String> {

    private static ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();

    }

    @Override
    public String convertToDatabaseColumn(RestaurantData attribute) {
        try {
            return mapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    @Override
    public RestaurantData convertToEntityAttribute(String dbData) {
        try {
            return mapper.readValue(dbData, new TypeReference<RestaurantData>() {
            });
        } catch (Exception e) {
            return null;
        }
    }

}