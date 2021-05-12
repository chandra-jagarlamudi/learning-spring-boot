/**
 * 
 */
package com.ragas.sprintboot.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.ragas.sprintboot.model.TimeResponse;

import reactor.core.publisher.Mono;

/**
 * @author Chandra.Jagarlamudi
 *
 */
@Component
public class MyApplicationReadyEvent {
	private static final Logger logger = LoggerFactory.getLogger(MyApplicationReadyEvent.class);

    @EventListener(ApplicationReadyEvent.class)
    public void applicationReady() {
    	logger.info("Working on My Application Ready Event");
        WebClient webClient = WebClient.create("http://time.jsontest.com/");
        Mono<TimeResponse> result = webClient
        								.get()
						                .retrieve()
						                .bodyToMono(TimeResponse.class);

        result.subscribe(res -> logger.info("Web client response: {}", res));
    }
}
