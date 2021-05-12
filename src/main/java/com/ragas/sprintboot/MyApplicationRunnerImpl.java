package com.ragas.sprintboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(value = 1)
@Component
public class MyApplicationRunnerImpl implements ApplicationRunner {
	private static final Logger logger = LoggerFactory.getLogger(MyApplicationRunnerImpl.class);

	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.info("Application started with ApplicationRunner implementation and ApplicationArguments ");
		logger.info("Option names : {}", args.getOptionNames());
		logger.info("Options : {}", args.getNonOptionArgs().toString());
		logger.info("###########################################################################");
	}

}