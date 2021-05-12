/**
 * 
 */
package com.ragas.sprintboot;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Chandra.Jagarlamudi
 *
 */
@Order(value = 3)
@Component
public class MyCommandLineRunnerImpl implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(MyCommandLineRunnerImpl.class);

	@Override
	public void run(String... args) throws Exception {
		logger.info("Application started with CommandLineRunner FIRST implementation and String... args");
		logger.info("command-line arguments: {}. To kill this application, press Ctrl + C.", Arrays.toString(args));
		logger.info("###########################################################################");
	}

}

@Order(value = 2)
@Component
class MyCommandLineRunnerSecondImpl implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(MyCommandLineRunnerSecondImpl.class);

	@Override
	public void run(String... args) throws Exception {
		logger.info("Application started with CommandLineRunner SECOND implementation and String... args");
		logger.info("###########################################################################");
	}

} 