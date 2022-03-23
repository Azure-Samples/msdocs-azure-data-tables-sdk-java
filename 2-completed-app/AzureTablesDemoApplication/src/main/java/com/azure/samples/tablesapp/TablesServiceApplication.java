// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.samples.tablesapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class TablesServiceApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		logger.info("Tables Service is initializing..............................");
		return application.sources(TablesServiceApplication.class);
	}

	public static void main(String[] args) {
		try {
			SpringApplication.run(TablesServiceApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
