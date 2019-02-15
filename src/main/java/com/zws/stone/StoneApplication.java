package com.zws.stone;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Slf4j
@RestController
@SpringBootApplication
public class StoneApplication {

	@Value("${server.port}")
	private Integer port;

	@GetMapping("/aaa")
	public User home() {
		log.info("This is home");
		log.warn("swwwss 33333333333333");
		return new User("zhangsan", new Date());
	}

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(StoneApplication.class);
		application.run(args);
	}

}

@Data
class User {

	private String name;

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date age;

	public User() {}
	public User(String name, Date age) {
		this.age = age;
		this.name = name;
	}
}

