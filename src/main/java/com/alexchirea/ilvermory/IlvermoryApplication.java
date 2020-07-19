package com.alexchirea.ilvermory;

import com.alexchirea.ilvermory.service.RoleService;
import com.alexchirea.ilvermory.service.RoleUserService;
import com.alexchirea.ilvermory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

@SpringBootApplication
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class IlvermoryApplication extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleUserService roleUserService;

	public static void main(String[] args) {
		SpringApplication.run(IlvermoryApplication.class, args);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated()
				.and()
				.x509()
				.subjectPrincipalRegex("CN=(.*?)(?:,|$)")
				.userDetailsService(userDetailsService())
				.and()
				.exceptionHandling().accessDeniedPage("/404");
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return username -> {
			if (userService.findByCN(username) != null) {
				List<GrantedAuthority> authorities = AuthorityUtils.
						commaSeparatedStringToAuthorityList(roleUserService.getRoleCodeCommaSeparated(username));
				return new User(username, "", authorities);
			}
			throw new UsernameNotFoundException("User not found!");
		};
	}

}
