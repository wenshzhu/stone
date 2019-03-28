package com.zws.stone;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;

@Slf4j
@RestController
@SpringBootApplication
@ServletComponentScan
public class StoneApplication {

	@Value("${server.port}")
	private Integer port;

	@Autowired
	private ApplicationContext applicationContext;

	@GetMapping("/aaa")
	public User home() {
		getParams();
		log.info("This is home");
		return new User("zhangsan", new Date());
	}

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(StoneApplication.class);
		application.run(args);
	}

	public void getParams() {
		Resource resource = applicationContext.getResource("classpath:static/abc.txt");
		try {
			String context = IOUtils.toString(resource.getInputStream(), "utf-8");
			System.out.println("aaaaaaaaaaaaa:" + context);
		} catch (IOException e) {
			e.printStackTrace();
		}
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

