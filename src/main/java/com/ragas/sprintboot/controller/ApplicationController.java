/**
 * 
 */
package com.ragas.sprintboot.controller;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @author Chandra.Jagarlamudi
 *
 */
public class ApplicationController {
	@Bean
    RouterFunction<ServerResponse> home() {
        return route(GET("/"), request -> ok().bodyValue("Home page"));
    }
}
