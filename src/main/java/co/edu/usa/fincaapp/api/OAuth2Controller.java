package co.edu.usa.fincaapp.api;

import java.util.Collections;
import java.util.Map;


import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OAuth2Controller extends WebSecurityConfigurerAdapter{
    
    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        return Collections.singletonMap("name", principal.getAttribute("name"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.cors()
        .and()
    //.sessionManagement()
    //    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    //    .and()
    .csrf()
        .disable()
    .formLogin()
        .disable()
    .httpBasic()
        .disable()
			.authorizeRequests(a -> a
				.antMatchers("/", "/error", "/webjars/**", "/css/**", "/image/**", "/js/**","/api/**").permitAll()
				.anyRequest().authenticated()
			)
			.exceptionHandling(e -> e
				.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
			)
			.csrf(c -> c
				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
			)
			.logout(l -> l
				.logoutSuccessUrl("/").permitAll()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID")
       
			)
			.oauth2Login().defaultSuccessUrl("/",true);

       http.cors().and().csrf().disable();
       
    }

}
