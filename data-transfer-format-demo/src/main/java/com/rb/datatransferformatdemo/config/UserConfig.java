package com.rb.datatransferformatdemo.config;

import com.rb.datatransferformatdemo.model.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class UserConfig {
    @Bean
    @Primary
    @ConditionalOnMissingBean
    public User getUserJYZ() {
        return new User("Jiang Yuzhou");
    }

    @Bean
    public User getUserDKY() {
        return new User("Dai Keyu");
    }
}
