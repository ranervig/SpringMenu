package dmacc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.MenuItem;

@Configuration
public class BeanConfiguration {

	@Bean
	public MenuItem menuItem() {
		MenuItem bean = new MenuItem("Burger", 4.99);
		return bean;
	}
}
