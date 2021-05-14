### Spring Boot Application
#### [Application Events](https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-application-events-and-listeners)
Spring Boot applications publish various events during the application startup, we can use listeners to react to these events.  

	
> Some events are actually triggered before the ApplicationContext is created, so you cannot register a listener on those as a @Bean. You can register them with the SpringApplication.addListeners(…​) method or the SpringApplicationBuilder.listeners(…​) method.
	
> If you want those listeners to be registered automatically, regardless of the way the application is created, you can add a META-INF/spring.factories file to your project and reference your listener(s) by using the org.springframework.context.ApplicationListener key, as shown in the following      
>> example: org.springframework.context.ApplicationListener=com.example.project.MyListener 

Application events are sent in the following order, as your application runs:

1. An `ApplicationStartingEvent` is sent at the start of a run but before any processing, except for the registration of listeners and initializers.
2. An `ApplicationEnvironmentPreparedEvent` is sent when the `Environment` to be used in the context is known but before the context is created.
3. An `ApplicationContextInitializedEvent` is sent when the `ApplicationContext` is prepared and `ApplicationContextInitializers` have been called but before any bean definitions are loaded.
4. An `ApplicationPreparedEvent` is sent just before the refresh is started but after bean definitions have been loaded.
5. An `ApplicationStartedEvent` is sent after the context has been refreshed but before any application and command-line runners have been called.
6. An `AvailabilityChangeEvent` is sent right after with `LivenessState.CORRECT` to indicate that the application is considered as live.
7. An `ApplicationReadyEvent` is sent after any application and command-line runners have been called.
8. An `AvailabilityChangeEvent` is sent right after with `ReadinessState.ACCEPTING_TRAFFIC` to indicate that the application is ready to service requests.
9. An `ApplicationFailedEvent` is sent if there is an exception on startup.

The above list only includes `SpringApplicationEvents` that are tied to a `SpringApplication`. In addition to these, the following events are also published after `ApplicationPreparedEvent` and before `ApplicationStartedEvent`:

- A `WebServerInitializedEvent` is sent after the WebServer is ready. `ServletWebServerInitializedEvent` and `ReactiveWebServerInitializedEvent` are the servlet and reactive variants respectively.
- A `ContextRefreshedEvent` is sent when an `ApplicationContext` is refreshed.

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