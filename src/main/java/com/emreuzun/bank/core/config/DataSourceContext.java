package com.emreuzun.bank.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.sql2o.Sql2o;

@Configuration
public class DataSourceContext {

    @Bean
    @Profile("dev")
    public Sql2o sql2oDev() {
        return new Sql2o("jdbc:h2:mem:bank-dev", "sa", "");
    }

    @Bean
    @Profile("prod")
    public Sql2o sql2oProd() {
        // todo
        return null;
    }
}
