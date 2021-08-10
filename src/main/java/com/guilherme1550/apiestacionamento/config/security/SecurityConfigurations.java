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
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.guilherme1550.apiestacionamento.repository.UsuarioEmpresaRepository;
import com.guilherme1550.apiestacionamento.service.AutenticacaoUsuarioEmpresaService;
import com.guilherme1550.apiestacionamento.service.TokenService;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

	@Autowired
	AutenticacaoUsuarioEmpresaService autenticacaoUsuarioEmpresa;
	
	@Autowired
	TokenService tokenService;
	
	@Autowired
	UsuarioEmpresaRepository usuarioEmpresaRepository;
	
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
			.antMatchers(HttpMethod.POST,"/usuario-empresa/auth" ).permitAll()
			.antMatchers(HttpMethod.POST,"/estacionamentos" ).permitAll()
			.antMatchers(HttpMethod.GET,"/estacionamentos/**" ).permitAll()
			.antMatchers(HttpMethod.PUT,"/estacionamentos/**" ).permitAll()
			.antMatchers(HttpMethod.DELETE,"/estacionamentos/**" ).permitAll()
			.antMatchers(HttpMethod.POST,"/controle/**" ).permitAll()
			.antMatchers(HttpMethod.GET,"/controle/**" ).permitAll()
			.antMatchers("/h2-console/**").permitAll()
			.anyRequest().authenticated()
			.and().csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and().headers().frameOptions().sameOrigin()
			.and().addFilterBefore(new AutenticacaoViaTokenFilter(tokenService, usuarioEmpresaRepository), 
					UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		super.configure(web);
	}

}
