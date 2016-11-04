package br.edu.utfpr.spring.trab;


import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/static/**").permitAll();
		http.authorizeRequests().antMatchers("/usuario/**").permitAll();
		// O que deseja que autentique
		// nesse para todos os request serão autenticados.
		http.csrf().disable().authorizeRequests().anyRequest().authenticated();
		
		// form de login customizado
		http.formLogin().loginPage("/login")// URL COM O RETORNO DO JSP DE LOGIN

				.defaultSuccessUrl("/pedido/")// DEPOIS DO LOGIN VAI PARA ONDE?
				.failureUrl("/login?error=bad_credentials") // SE FALHAR FAZ O
															// QUE?
				.permitAll();// PERMISSÃO DE ACESSO TOTAL AO LOGIN

	
        
	}
}
