package com.guilherme1550.apiestacionamento.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.guilherme1550.apiestacionamento.service.AutenticacaoUsuarioEmpresaService;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

	@Autowired
	AutenticacaoUsuarioEmpresaService autenticacaoUsuarioEmpresa;
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(autenticacaoUsuarioEmpresa).passwordEncoder(new BCryptPasswordEncoder());
	}

	// Configurações de Autorização
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/empresas/**").permitAll()
			.antMatchers(HttpMethod.POST,"/empresas/**" ).permitAll()
			.antMatchers("/h2-console/**").permitAll()
			.and().csrf().disable()
			.headers().frameOptions().sameOrigin();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		super.configure(web);
	}

}
