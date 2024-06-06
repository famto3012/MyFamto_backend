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
public class TagsModel
        implements
        AttributeConverter<List<TagsModel>, String> {


    private static ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();

    }

    protected String name;
    protected Boolean status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String convertToDatabaseColumn(List<TagsModel> attribute) {
        try {
            return mapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    @Override
    public List<TagsModel> convertToEntityAttribute(String dbData) {
        try {
            return mapper.readValue(dbData, new TypeReference<List<TagsModel>>() {
            });
        } catch (Exception e) {
            return null;
        }
    }

}