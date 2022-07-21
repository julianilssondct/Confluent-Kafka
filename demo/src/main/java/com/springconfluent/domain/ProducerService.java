package com.springconfluent.domain;

import com.fasterxml.jackson.databind.JsonNode;

public interface ProducerService {
    void sendMessage(JsonNode message);
}
