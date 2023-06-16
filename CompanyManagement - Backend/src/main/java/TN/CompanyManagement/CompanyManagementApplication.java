package TN.CompanyManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.Executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
@EnableScheduling
public class CompanyManagementApplication {

	private static final Logger logger = LoggerFactory.getLogger(CompanyManagementApplication.class);

	@Value("${server.port}")
	private Integer port;

	@Bean(name = "threadPoolTaskExecutor")
	public Executor threadPoolTaskExecutor() {
		return new ThreadPoolTaskExecutor();
	}

	public static void main(String[] args) throws UnknownHostException {
		SpringApplication app = new SpringApplication(CompanyManagementApplication.class);
		Environment env = app.run(args).getEnvironment();

		String protocol = "http";;
		logger.info(
				"\n----------------------------------------------------------\n\t"
						+ "Application '{}' is running! Access URLs:\n\t" + "Local: \t\t{}://localhost:{}{}\n\t"
						+ "External: \t{}://{}:{}{}\n\t"
						+ "Profile(s): \t{}\n\t"
						+ "Swagger Link: \t{}://{}:{}{}/swagger-ui/index.html?configUrl={}/v3/api-docs/swagger-config \n"
						+ "----------------------------------------------------------",
				env.getProperty("spring.application.name"), protocol,
				env.getProperty("server.port"), env.getProperty("server.servlet.context-path"), protocol,
				InetAddress.getLocalHost().getHostAddress(), env.getProperty("server.port"), env.getProperty("server.servlet.context-path"),
				env.getActiveProfiles(), protocol,
				InetAddress.getLocalHost().getHostAddress(), env.getProperty("server.port"), env.getProperty("server.servlet.context-path"), env.getProperty("server.servlet.context-path"));
	}

}
