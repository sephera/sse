package com.example.sse;

import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.LocalTime;
import java.util.UUID;

@RestController
@RequestMapping("/event-stream")
public class EventStreamController {

    @GetMapping(path = "/flux")
    public Flux<ServerSentEvent<String>> streamFlux() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(sequence -> ServerSentEvent.<String>builder().id(UUID.randomUUID().toString()).event("stream-flux").data("SSE - " + LocalTime.now().toString()).build());
    }
}
