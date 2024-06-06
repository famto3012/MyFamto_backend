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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(includeFieldNames = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductTagsModel
        implements
        AttributeConverter<List<ProductTagsModel>, String> {


    private static ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();

    }

    protected String tags;

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public String convertToDatabaseColumn(List<ProductTagsModel> attribute) {
        try {
            return mapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    @Override
    public List<ProductTagsModel> convertToEntityAttribute(String dbData) {
        try {
            return mapper.readValue(dbData, new TypeReference<List<ProductTagsModel>>() {
            });
        } catch (Exception e) {
            return null;
        }
    }


}