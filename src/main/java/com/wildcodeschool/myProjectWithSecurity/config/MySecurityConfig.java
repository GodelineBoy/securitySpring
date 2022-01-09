package com.wildcodeschool.myProjectWithSecurity.config;


import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class MySecurityConfig  extends WebSecurityConfigurerAdapter {

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http 
		// instance http pour add des blocs de parametres
		.authorizeRequests()
		//para qui active la securite - bloc qui dmd authentification sur chaq requete
			//.anyRequest().authenticated()
			//veut que : pr n'importe qu'elle requete, je veux que l'user soit authentifie
		
			.antMatchers("/avengers/assemble").hasRole("CHAMPION")
			.antMatchers("/secret-bases").hasRole("DIRECTOR")
			.and()
			// au autre bloc
		.formLogin()
		//precise que l'authentification passe par un formulaire de connexion
			.and()
			//un autre bloc
		.httpBasic();
		//pour config l'authentification basique HTTP
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.inMemoryAuthentication()
			.withUser("Steve")
				.password(encoder.encode("motdepasse"))
				.roles("CHAMPION")
				.and()
			.withUser("Nick")
				.password(encoder.encode("flerken"))
				.roles("DIRECTOR");

}
}