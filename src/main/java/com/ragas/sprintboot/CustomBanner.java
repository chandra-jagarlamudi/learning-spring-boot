/**
 * 
 */
package com.ragas.sprintboot;

import java.io.PrintStream;

import org.springframework.boot.Banner;
import org.springframework.core.env.Environment;

/**
 * @author Chandra.Jagarlamudi
 *
 */
public class CustomBanner implements Banner {

	@Override
	public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
		out.println("################################");
		out.println("##### Learning Spring boot #####");
		out.println("################################");
	}

}
