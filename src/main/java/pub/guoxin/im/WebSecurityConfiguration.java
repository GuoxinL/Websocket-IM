package pub.guoxin.im;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by guoxin on 17-5-25.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //设置拦截规则
                .antMatchers("/").not()
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                //开启默认登录页面
                .formLogin()
                //默认登录页面
                .loginPage("/login")
                //默认登录成功跳转页面
                .defaultSuccessUrl("/chat")
                .permitAll()
                .and()
                //设置注销
                .logout()
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("lenve").password("111").roles("USER")
                .and()
                .withUser("sang").password("222").roles("USER");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //设置不拦截规则
        web.ignoring().antMatchers("/resources/static/**");
    }
}