package com.hk.marketplace.config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
//import org.spacademy.clinic_hms.filter.CustomAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.hk.marketplace.enums.UserRole;

import lombok.Data;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private final UserDetailsService userDetailsService;

	@Autowired
	private JwtFilter jwtFilter;

	public SecurityConfig(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		return http
				.cors(Customizer.withDefaults()) // Enable CORS support
				.csrf(customizer -> customizer.disable())
				.authorizeHttpRequests(request -> request
						.requestMatchers("/users/login", "/users/register","/api/franchisor-brands").permitAll()
						// .requestMatchers("/api/franchisor-brands").hasAuthority(UserRole.FRANCHISOR.name())
						.anyRequest().authenticated())
				.formLogin(Customizer.withDefaults())
				.httpBasic(Customizer.withDefaults())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
				.build();
	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000", "http://localhost:5173")); // List
																											// multiple
																											// origins
		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type", "Access-Control-Allow-Origin")); // Add
																														// required
																														// headers
		configuration.setExposedHeaders(Arrays.asList("Authorization")); // Optional: Expose headers if needed
		configuration.setAllowCredentials(true);

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		// provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		provider.setPasswordEncoder(passwordEncoder());
		provider.setUserDetailsService(userDetailsService);
		return provider;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(12);
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

	// @Bean
	// public UserDetailsService userDetailsService() {
	//
	// UserDetails user1 = User
	// .withDefaultPasswordEncoder()
	// .username("gan")
	// .password("gan")
	// .roles("USER")
	// .build();
	// UserDetails user2 = User
	// .withDefaultPasswordEncoder()
	// .username("adi")
	// .password("adi")
	// .roles("ADMIN")
	// .build();
	// return new InMemoryUserDetailsManager(user1, user2);
	// }
	//

	// @Bean
	// public SecurityFilterChain securityFilterChain(HttpSecurity http) throws
	// Exception {
	//
	// http.csrf(customizer -> customizer.disable());
	// http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
	// http.formLogin(Customizer.withDefaults());
	// http.httpBasic(Customizer.withDefaults());
	// http.sessionManagement(session ->
	// session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
	// return http.build();
	//
	//
	// }
	//

	// @Bean
	// public SecurityFilterChain securityFilterChain(HttpSecurity http,
	// AuthenticationManager authManager) throws Exception {
	//
	// CustomAuthenticationFilter caf =new CustomAuthenticationFilter();
	// caf.setAuthenticationManager(authManager);
	//
	// http.csrf(customizer -> customizer.disable());
	// http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
	// http.formLogin(Customizer.withDefaults());
	// http.httpBasic(Customizer.withDefaults());
	//
	// http.addFilterBefore(caf, UsernamePasswordAuthenticationFilter.class);
	//
	// return http.build();
	// }
	//
	// @Bean
	// public AuthenticationManager authManager(AuthenticationConfiguration
	// authenticationConfiguration) throws Exception {
	// // Retrieves the default AuthenticationManager built by Spring Security
	// return authenticationConfiguration.getAuthenticationManager();
	// }

}
