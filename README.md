### Spring Boot Application
#### Application Events
Spring Boot applications publish various events during the application startup, we can use listeners to react to these events.   

The `ApplicationStartedEvent` is one such event published by Spring Boot after the context has been created but before `Application` and `CommandLine` runners have been called. Similarly `ApplicationReadyEvent` is published after `Application` and `CommandLine` have been called. It indicates that the application is ready to service requests.   

This Spring Boot application is a simple web application that triggers a web request in reaction to the `ApplicationReadyEvent`. The request is made using WebClient, so we add `spring-boot-starter-webflux` to POM file for building WebFlux applications using Spring Framework's Reactive Web support.

Here is the main event listener class code

	@Component
	public class MyApplicationReadyEvent {
		private static final Logger logger = LoggerFactory.getLogger(MyApplicationReadyEvent.class);
	
	    @EventListener(ApplicationReadyEvent.class)
	    public void applicationReady() {
			//we make the call to http://time.jsontest.com/ and log the time.
	    }
	}
	
On running the application you see the log entry

	2021-05-12 16:26:23.672  INFO 11212 --- [           main] c.r.s.event.MyApplicationReadyEvent      : Working on My Application Ready Event
	2021-05-12 16:26:24.036  INFO 11212 --- [ctor-http-nio-3] c.r.s.event.MyApplicationReadyEvent      : Web client response: TimeResponse{date='05-12-2021', unixtime=null, time='09:26:24 PM'}