package com.codestuff.springcache.config;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import net.spy.memcached.MemcachedClient;

@SpringBootApplication
@ComponentScan(basePackages = { "com.codestuff.springcache.*" })
public class Application {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		LOGGER.info("Application is ready.");
	}

	@Bean
	public MemcachedClient cacheClient() {
		InetSocketAddress ia = new InetSocketAddress("localhost", 11211);
		MemcachedClient cacheClient = null;
		try {
		 cacheClient = new MemcachedClient(ia);
		} catch (IOException e) {
			e.printStackTrace();
		}
		LOGGER.info("Cache setup done.");
		return cacheClient;
	}
}
