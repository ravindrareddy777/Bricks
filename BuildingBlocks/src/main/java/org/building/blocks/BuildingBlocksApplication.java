package org.building.blocks;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BuildingBlocksApplication {
private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	public static final String CONFIG_ENV_VAR_NAME = "SPRING_APPLICATION_JSON";
	public static void main(String[] args) {
		final String springApplicationJson = System.getenv(CONFIG_ENV_VAR_NAME);
		if (springApplicationJson != null && springApplicationJson.contains("{")) {
			logger.debug("main: successfully parsed configuration from environment {}", CONFIG_ENV_VAR_NAME);
		} else {
			logger.warn("main: no configuration found in environment {}", CONFIG_ENV_VAR_NAME);
		}
		SpringApplication.run(BuildingBlocksApplication.class, args);
		
		
	}

}
