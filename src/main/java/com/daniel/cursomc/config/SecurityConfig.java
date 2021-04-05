package com.daniel.cursomc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.daniel.cursomc.security.JWTAuthenticationFilter;
import com.daniel.cursomc.security.JWTAuthorizationFilter;
import com.daniel.cursomc.security.JWTUtil;

import io.jsonwebtoken.lang.Arrays;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired // injetando a interface
	private UserDetailsService userDetailsService;
	
	@Autowired
    private org.springframework.core.env.Environment env;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	private static final String[] PUBLIC_MATCHERS = { // estará liberado por padrão
			"/h2-console/**"
	};

	private static final String[] PUBLIC_MATCHERS_GET = { // cans que só permite recuperar  os dados
			"/produtos/**",
			"/categorias/**",
			"/estados/**"
	};

	private static final String[] PUBLIC_MATCHERS_POST = { //endpoints q permite o post
			"/clientes/**",
			"/auth/forgot/**"
	};

	@Override
	protected void configure(HttpSecurity http) throws Exception {   
		
		if (java.util.Arrays.asList(env.getActiveProfiles()).contains("test")) { // pegando pfiles ativos do projeto, se estiver no profuile test, vou querer cessar o db h2
            http.headers().frameOptions().disable(); // liberando acessoao h2
        }
		
		http.cors().and().csrf().disable(); // configuraçãoes, desabilitando csrf método de segurança
		http.authorizeRequests().antMatchers(HttpMethod.POST, PUBLIC_MATCHERS_POST).permitAll()
			.antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll()
			.antMatchers(PUBLIC_MATCHERS).permitAll()
			.anyRequest().authenticated();  // para todo resto exige autenticação
		http.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtUtil));
		http.addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtUtil, userDetailsService));
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // n cria sessão de usuário
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder()); //esse é capaz de buscar por email
	}
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() { // método cors
		CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();  // permite acesso de múltiplas fontes com configurações básicas
		configuration.setAllowedMethods(java.util.Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return (CorsConfigurationSource) source;
	}
	
	@Bean   
	public BCryptPasswordEncoder bCryptPasswordEncoder() { // encriptando senha
		return new BCryptPasswordEncoder();
	}
}
