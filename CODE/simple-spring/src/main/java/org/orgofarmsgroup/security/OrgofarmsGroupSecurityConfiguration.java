package org.orgofarmsgroup.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class OrgofarmsGroupSecurityConfiguration extends WebSecurityConfigurerAdapter{
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//super.configure(auth);
		auth.inMemoryAuthentication()
			.passwordEncoder(passwordEncoder)
			.withUser("user")
			.password(passwordEncoder.encode("user"))
			.roles("USER")
			.and()
			.withUser("admin")
			.password(passwordEncoder.encode("admin"))
			.roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		String[] permitAllArray = {
				"/","static/css","static/js",
				"/hello",
				"/user","/user/authorized","/user/authenticate",
				"/employee/**",
				"/admin","/admin/authorized","/admin/authenticate"
		};
		http
			.authorizeRequests()
			.antMatchers(permitAllArray).permitAll()
			.antMatchers("/admin/authorized/**").hasRole("ADMIN")
			.antMatchers("/user/authorized/**").hasAnyRole("ADMIN","USER")
	        .anyRequest().authenticated()
	        .and().httpBasic().and().formLogin()
			.and().csrf().disable()
		;
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder(12);
	}
}
