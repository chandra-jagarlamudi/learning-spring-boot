### [Spring Boot Application](https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-spring-application)
#### [Externalized Configuration](https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-external-config)
Spring Boot lets you externalize your configuration so that you can work with the same application code in different environments. You can use a variety of external configuration sources, include Java properties files, YAML files, environment variables, and command-line arguments.

Property values can be injected directly into your beans by using the `@Value` annotation, accessed through Spring’s Environment abstraction, or be bound to structured objects through `@ConfigurationProperties`.

Config data files are considered in the following order:

1. Application properties packaged inside your jar (application.properties and YAML variants).

2. Profile-specific application properties packaged inside your jar (application-{profile}.properties and YAML variants).

3. Application properties outside of your packaged jar (application.properties and YAML variants).

4. Profile-specific application properties outside of your packaged jar (application-{profile}.properties and YAML variants).

> >*It is recommended to stick with one format for your entire application. If you have configuration files with both* <em>**.properties**</em> *and* <em>**.yml**</em> *format in the same location,* <em>**.properties**</em> *takes precedence. Further, a property defined in* <em>**application.properties**</em> *and placed in* <em>**src/main/resources/config**</em> * directory will take precedence and override properties from other locations in case of a collision.*

#####Accessing Command Line Properties   
By default, SpringApplication converts any command line option arguments (that is, arguments starting with `--`, such as `--server.port=9000`) to a property and adds them to the Spring Environment. Command line properties always take precedence over file based property sources.

If you do not want command line properties to be added to the Environment, you can disable them by using `SpringApplication.setAddCommandLineProperties=false`.

#####External Application Properties
Spring Boot will automatically find and load application.properties and application.yaml files from the following locations when your application starts:

1. The classpath root
2. The classpath `/config` package
3. The current directory
4. The `/config` subdirectory in the current directory
5. Immediate child directories of the `/config` subdirectory

The list is ordered by precedence (with values from lower items overriding earlier ones). Documents from the loaded files are added as PropertySources to the Spring Environment.

If you do not like application as the configuration file name, you can switch to another file name by specifying a `spring.config.name` environment property. You can also refer to an explicit location by using the `spring.config.location` environment property (which is a comma-separated list of directory locations or file paths). The following example shows how to specify a different file name:

	$ java -jar myproject.jar --spring.config.name=myproject

The following example shows how to specify two locations:

	$ java -jar myproject.jar --spring.config.location=optional:classpath:/default.properties,optional:classpath:/override.properties
	
**Example: Spring Boot @ConfigurationProperties annotation and Binding external configurations to POJO classes**    

Build and run the app using maven

	mvn package
	java -jar target/config-properties-demo-0.0.1-SNAPSHOT.jar

Alternatively, you can run the app directly without packaging like this -

	mvn spring-boot:run

The application can be accessed at http://localhost:8080, below is the response

	{
	    "roles": "[USER, ADMIN, PARTNER]",
	    "name": "Spring Boot externalized configuration",
	    "description": "Spring Boot externalized configuration is a learning exercise demonstrating loading, binding and validating configuration properties in spring boot application ",
	    "permissions": "{CAN_VIEW_USERS=true, CAN_EDIT_USERS=true, CAN_DELETE_USERS=false, CAN_DELETE_POSTS=false, CAN_VIEW_POSTS=true, CAN_EDIT_POSTS=true}"
	}