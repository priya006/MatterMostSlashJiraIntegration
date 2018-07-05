package io.github.scottleedavis.mattermost.slashjira;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"io.github.scottleedavis.mattermost.slashjira"})
public class SlashjiraApplication {

	public static void main(String[] args) {
		SpringApplication.run(SlashjiraApplication.class, args);
	}
}
