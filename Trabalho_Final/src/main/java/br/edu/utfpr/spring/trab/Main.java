package br.edu.utfpr.spring.trab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
public class Main extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(Main.class);
	}

	 /*
	 * @Bean indica ao spring que a classe abaixo irá ser gerenciada por ele
	 * Além de criar a classe WebSecurityConfig
	 */
	 @Bean
	 public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter(){
	 return new WebSecurityConfig();
	 }

}
