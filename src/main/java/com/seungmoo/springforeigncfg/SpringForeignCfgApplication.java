package com.seungmoo.springforeigncfg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@SpringBootApplication
//@EnableConfigurationProperties(SeungmooProperties.class) --> 자동으로 등록 됨, 대신 properties 자바 파일을 bean으로 등록
public class SpringForeignCfgApplication {

	@ConfigurationProperties("server") // 이렇게 Properties를 쓰는 건 흔한 케이스는 아님
	@Bean
	@Primary // 다른 디펜던시의 ServerProperties class 때문에 충돌 발생하게됨
	public ServerProperties serverProperties() {
		return new ServerProperties();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringForeignCfgApplication.class, args);
	}

}
