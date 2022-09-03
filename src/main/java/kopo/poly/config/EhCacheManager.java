package kopo.poly.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.cache.CacheManager;

import java.util.Objects;

@RequiredArgsConstructor
@EnableScheduling
@Slf4j
public class EhCacheManager {
    private final CacheManager cacheManager;

    /**
     * All day 00h 에 Cache Clear
     */
    @Scheduled(cron = "0 0 0 * * *")
    private void clearAll() {
        log.info("Clear Cache");
        for (String cacheName : cacheManager.getCacheNames()) {
            Objects.requireNonNull(cacheManager.getCache(cacheName)).clear();
        }
    }
}
