package com.diverger.starwars.configuration;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.ArrayList;
import java.util.List;


@Configuration
@EnableCaching
public class CacheConfiguration {

    @Bean
    public CacheManager cacheManager() {
        List<CaffeineCache> cachesList = new ArrayList<CaffeineCache>();

        for(var name : CacheNames.values())
            cachesList.add(new CaffeineCache(name.toString(), Caffeine.newBuilder().build(),false));

        var manager = new SimpleCacheManager();
        manager.setCaches(cachesList);

        return manager;
    }

}
