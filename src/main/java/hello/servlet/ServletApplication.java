package hello.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


//스프링 부트 서블릿 환경 구성 -> @ServletComponentScan
@ServletComponentScan	//서블릿 자동 등록
@SpringBootApplication
public class ServletApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServletApplication.class, args);
	}
	/*
	@Bean
	InternalResourceViewResolver internalResourceViewResolver(){
		return new InternalResourceViewResolver("/WEB-INF/views/" , ".jsp");
	}

	 */

}
