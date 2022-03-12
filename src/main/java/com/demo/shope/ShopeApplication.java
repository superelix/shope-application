package com.demo.shope;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude =  {DataSourceAutoConfiguration.class })
@ComponentScan({"com.demo.shopme"})
public class ShopeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopeApplication.class, args);
	}

}
