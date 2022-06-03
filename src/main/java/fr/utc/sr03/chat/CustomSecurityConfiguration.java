package fr.utc.sr03.chat;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
public class CustomSecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());

		http.httpBasic()
				// Permit all
				.and()
				.authorizeRequests()
				.anyRequest().permitAll()
				// Desactivation Spring CSRF protection pour POST
				.and().csrf().disable().cors();
	}
}