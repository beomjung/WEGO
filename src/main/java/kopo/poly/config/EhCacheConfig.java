package kopo.poly.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Objects;


/**
 * Cache Config Class
 */
@Slf4j
@EnableCaching
@Configuration
@RequiredArgsConstructor
@EnableScheduling
public class EhCacheConfig {
    private final CacheManager cacheManager;

    /**
     * 변경이 자주 없는 Data (관광 정보)이기 때문에 매일 00시에 일괄 Cache Clear
     */
    @Scheduled(cron = "0 0 0 * * *")
    private void clearAll() {
        log.info("Clear Cache");
        for (String cacheName : cacheManager.getCacheNames()) {
            Objects.requireNonNull(cacheManager.getCache(cacheName)).clear();
        }
    }
}
