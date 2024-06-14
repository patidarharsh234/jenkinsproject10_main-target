package com.rays.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rays.common.ORSResponse;

import java.io.IOException;

public class LongDeserializer extends JsonDeserializer<Long> {
	   ORSResponse res=new ORSResponse();
    @Override
    public Long deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.getCodec().readTree(p);
        String value = node.asText();

        try {
            return Long.parseLong(value);
        } catch (NumberFormatException e) {
            throw new IOException("Invalid Long value: " + value);
             
        }
    }
    
    //this class use for @JsonDeserialize(using = LongDeserializer.class) this annotation
}
