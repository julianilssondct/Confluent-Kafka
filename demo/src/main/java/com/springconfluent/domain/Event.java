package com.springconfluent.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(required = true, additionalProperties = Schema.AdditionalPropertiesValue.FALSE)
/*@io.confluent.kafka.schemaregistry.annotations.Schema(value="{\n" +
    "  \"$schema\": \"http://json-schema.org/draft-07/schema#\",\n" +
    "  \"additionalProperties\": false,\n" +
    "  \"description\": \"Schema for event in topic_0\",\n" +
    "  \"properties\": {\n" +
    "    \"message\": {\n" +
    "      \"description\": \"Message\",\n" +
    "      \"type\": \"string\"\n" +
    "    }\n" +
    "  },\n" +
    "  \"required\": [\n" +
    "    \"message\"\n" +
    "  ],\n" +
    "  \"title\": \"Event Schema\",\n" +
    "  \"type\": \"object\"\n" +
    "}", refs={@io.confluent.kafka.schemaregistry.annotations.SchemaReference(
    name="ref.json", subject="reference")})*/
@Data
public class Event {
  @JsonProperty
  public JsonNode event;
}
