package co.edu.usco.springBoot_jpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(auth -> auth
				.dispatcherTypeMatchers(DispatcherType.FORWARD, DispatcherType.ERROR).permitAll()
				.requestMatchers("/productos/nuevo", "/productos/guardar").hasAnyAuthority("ADMIN", "CREATOR")
				.requestMatchers("/productos/editar/**", "/productos/actualizar/**").hasAnyAuthority("ADMIN", "EDITOR")
				.requestMatchers("/productos/eliminar/**").hasAuthority("ADMIN")
				.requestMatchers("/", "/productos").hasAnyAuthority("USER", "CREATOR", "EDITOR", "ADMIN")
				.anyRequest().authenticated())
			.formLogin(form -> form
				.loginPage("/login")
				.defaultSuccessUrl("/productos", true)
				.permitAll())
			.logout(logout -> logout
				.logoutSuccessUrl("/login?logout")
				.permitAll())
			.exceptionHandling(ex -> ex
				.accessDeniedPage("/403"));

		return http.build();
	}

}
