package pl.sda.meetup.myownmeetup.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class BasicSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()//to autoryzuje nasze requesty
                .antMatchers("/restricted").authenticated()//tu mówimy żę jeśli wejdzie ktoś na tą stronę to musi on być zautentykowany
                .anyRequest()//jaki kolwiek request przyjdzie
                .permitAll()//wpuszczaj wszystko
                .and()
                .csrf().disable()//
                .headers().frameOptions().disable()//
                .and()
                .formLogin()
                .loginPage("/sign-in")
                .loginProcessingUrl("/login-process")
                .usernameParameter("password")
                .failureUrl("/sign-in?error=true")
                .defaultSuccessUrl("/event");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //my dosytajemy tu bildera nie tworzymy obiektu, ale musimy mu powiedzieć co ma robić
        auth.jdbcAuthentication().dataSource(dataSource)
                //data source to interfejs z jdbc, jpa z niego też korzysta ale pod spodem, możemy go wyciągnąć tworząc z niego beana
                //dzięki temu wskazujemy z jakiej bazy ma pobierać dane do autentykacji
                .usersByUsernameQuery("SELECT u.name, u.password, 1 FROM user u WHERE u.name = ?")
                //tam powyżej te stringi mają odpowiadać nazwą kolumn w bazie danych
                //ta jedynka to aktywność naszego użytkownika
                //wpisujemy tam na sztywno że każdy jest aktywny bo nie mamy jeszcze określonej aktywności
                .authoritiesByUsernameQuery("SELECT u.name, r.role_name FROM user u JOIN user_roles ur ON u.id = ur.user_id" +
                        "JOIN role r ON ur.roles_id = r.id" +
                        "WHERE u.name = ?")//TODO tu może być błąd w nazwie tabeli user_roles
                .passwordEncoder(passwordEncoder);
    }
}
