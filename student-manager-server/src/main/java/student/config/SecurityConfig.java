package student.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import student.bean.RetCode;
import student.entity.User;
import student.filter.LoginFilter;
import student.util.JsonUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * @author hui
 * @date 2022-01-08 10:24:47
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private UserDetailsService userDetailsService;

    @Bean
    LoginFilter loginFilter() throws Exception {
        LoginFilter loginFilter = new LoginFilter();
        //登录成功处理
        loginFilter.setAuthenticationSuccessHandler((request, response, authentication) -> {
            User user = (User) authentication.getPrincipal();
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            JsonUtil.response(response, RetCode.LOGIN_SUCCESS);
        });
        loginFilter.setAuthenticationManager(authenticationManager());
        return loginFilter;
    }

    @Bean
    GrantedAuthorityDefaults grantedAuthorityDefaults() {
        return new GrantedAuthorityDefaults("");
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //任何请求需要先登录
        http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/student/**").hasRole("admin")
                .anyRequest()
                .authenticated();
        //异常处理
        http.exceptionHandling()
                //未登录
                .authenticationEntryPoint((request, response, e) -> {
                    JsonUtil.response(response, RetCode.NO_LOGGED);
                })
                //无权限
                .accessDeniedHandler((request, response, e) -> {
                    JsonUtil.response(response, RetCode.PERMISSION_DENIED);
                });
        //JSON登录
        http.addFilterAt(loginFilter(), UsernamePasswordAuthenticationFilter.class);
        //关闭CSRF
        http.csrf().disable();
    }
}
