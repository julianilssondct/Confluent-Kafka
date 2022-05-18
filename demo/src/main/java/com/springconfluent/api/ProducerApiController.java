package com.springconfluent.api;

import com.springconfluent.domain.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerApiController {

  @Autowired
  private ProducerService producerService;

  @PostMapping("/produce")
  public void produce(@RequestBody String event) {
    producerService.sendMessage(event);
  }
}
