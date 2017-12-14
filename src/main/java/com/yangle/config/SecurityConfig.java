package com.yangle.config;

/**
 * Created by yangle on 2017/10/12.
 */
import com.yangle.security.CustAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustAuthenticationProvider custProvider;
    @Autowired
    private AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> authenticationDetailsSource;
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("yiibai").password("123456").roles("USER");
//        auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
//        auth.inMemoryAuthentication().withUser("dba").password("123456").roles("DBA");
        auth.authenticationProvider(custProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http  .authorizeRequests()
                // 例如以下代码指定了/和/index不需要任何认证就可以访问，其他的路径都必须通过身份验证。
                .antMatchers("/", "/index","/defaultKaptcha","/css/**","/image/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .failureUrl("/login?error")
                .defaultSuccessUrl("/home",true)
                .loginPage("/login")
                .permitAll()
                .authenticationDetailsSource(authenticationDetailsSource)
                .and()
                .logout()
                .logoutSuccessUrl("/login?logout")//退出登录后的默认url是"/home"
                .permitAll();
        http.csrf().disable();
        super.configure(http);
    }
}