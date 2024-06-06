package com.example.famto.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import javax.persistence.AttributeConverter;
import java.util.List;

//import com.fasterxml.jackson.annotation.JsonTypeInfo;

@SuppressWarnings("rawtypes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(includeFieldNames = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OftenBoughtTogetherModel
        implements
        AttributeConverter<List<OftenBoughtTogetherModel>, String> {


    private static ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();

    }

    protected String boughtTogetherProducts;

    public String getBoughtTogetherProducts() {
        return boughtTogetherProducts;
    }

    public void setBoughtTogetherProducts(String boughtTogetherProducts) {
        this.boughtTogetherProducts = boughtTogetherProducts;
    }

    @Override
    public String convertToDatabaseColumn(List<OftenBoughtTogetherModel> attribute) {
        try {
            return mapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    @Override
    public List<OftenBoughtTogetherModel> convertToEntityAttribute(String dbData) {
        try {
            return mapper.readValue(dbData, new TypeReference<List<OftenBoughtTogetherModel>>() {
            });
        } catch (Exception e) {
            return null;
        }
    }


}