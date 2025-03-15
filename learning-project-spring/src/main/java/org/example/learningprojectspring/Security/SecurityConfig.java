package org.example.learningprojectspring.Security;
import lombok.AllArgsConstructor;
import org.example.learningprojectspring.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private final AppUserService appUserService;


    @Bean
    public UserDetailsService userDetailsService(){
        return appUserService;
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(appUserService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(httpForm ->{
                    httpForm.loginPage("/req/login").permitAll();
                    httpForm.defaultSuccessUrl("/index", true);

                })
                .authorizeHttpRequests(registry ->{
                    registry.requestMatchers("/req/register","/css/**","/js/**").permitAll();
                    registry.anyRequest().authenticated();
                })
                .logout(logout ->{
                    logout.logoutUrl("/logout");
                    logout.logoutSuccessUrl("/req/login")
                            .invalidateHttpSession(true)
                            .deleteCookies("JSESSIONID")
                            .permitAll();

                })
                .build();
    }
}
