### Spring Boot Application
#### ApplicationRunner or CommandLineRunner   
If you need to run some specific code once the `SpringApplication` has started, you can implement the `ApplicationRunner` or `CommandLineRunner` interfaces. Both interfaces work in the same way and offer a single run method, which is called just before `SpringApplication.run(…​)` completes.
> This contract is well suited for tasks that should run after application startup but before it starts accepting traffic.   

The `CommandLineRunner` interface provides access to application arguments as a string array, whereas the `ApplicationRunner` uses the `ApplicationArguments` interface. 
    
If several `CommandLineRunner` or `ApplicationRunner` beans are defined that must be called in a specific order, you can additionally implement the org.springframework.core.Ordered interface or use the org.springframework.core.annotation.Order annotation.

**Why these interface?**       
1. To execute code that only have to be run once, right after application startup
2. Spring Batch relies on these runners in order to trigger the execution of the jobs
3. Use dependency injection to our advantage in order to wire in whatever dependencies we need and in whatever way/order we want – in run() method implementation.
