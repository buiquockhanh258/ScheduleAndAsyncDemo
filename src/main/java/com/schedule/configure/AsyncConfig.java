/**
 * 
 */
package com.schedule.configure;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author KhanhBQ3
 *
 */
@Configuration
public class AsyncConfig {
	@Bean
	public Executor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		//set default pool size, if not default = 1
		executor.setCorePoolSize(5);
		//set max pool size
		executor.setMaxPoolSize(10);
		//set max queue capacity
		executor.setQueueCapacity(100);
		//set name for Thread
		executor.setThreadNamePrefix("Thread-");
		executor.initialize();
		return executor;
	}
}
