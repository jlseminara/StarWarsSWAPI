package com.diverger.starwars.configuration;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.support.NoOpCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@TestConfiguration
public class CacheConfiguration {
    @Bean
    public CacheManager cacheManager() {

        return new NoOpCacheManager();
    }
}
