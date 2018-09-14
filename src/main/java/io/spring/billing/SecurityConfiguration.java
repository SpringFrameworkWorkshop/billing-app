package io.spring.billing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Autowired
  private UserDetailsService userDetailsServiceImpl;

  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
      .passwordEncoder(org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance())
      .withUser("user1").password("secret1").roles("USER")
      .and()
      .withUser("supervisor1").password("secret1").roles("USER", "SUPERVISOR")
      .and()
      .withUser("admin1").password("secret1").roles("USER", "ADMIN");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
            .antMatchers("/","/css/**","/js/**","/images/**","/login","/logout").permitAll()
            .antMatchers("/bill-*/**").hasAnyRole("SUPERVISOR","ADMIN")
            .antMatchers("/*-delete/**").hasAnyRole("ADMIN")
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/clients")
            .permitAll()
            .and()
        .logout()
            .permitAll();
  }
}
