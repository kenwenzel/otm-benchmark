package cz.cvut.kbss.benchmark.komma.util;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheStats;
import com.google.common.collect.ImmutableMap;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import net.enilink.komma.dm.change.IDataChangeTracker;
import net.enilink.komma.em.internal.CachedEntity;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

/**
 * Represents a disabled cache.
 *
 * This is done so that all the frameworks have the same conditions. JOPA and has also disabled cache for the benchmark.
 */
public class DisabledCacheModule extends AbstractModule {
    @Override
    protected void configure() {
    }

    @Provides
    @Singleton
    Cache<Object, CachedEntity> provideCache(IDataChangeTracker changeTracker) {
        return new Cache<Object, CachedEntity>() {
            @Override
            public CachedEntity getIfPresent(Object o) {
                return null;
            }

            @Override
            public CachedEntity get(Object o, Callable<? extends CachedEntity> callable) throws ExecutionException {
                return new CachedEntity();
            }

            @Override
            public ImmutableMap<Object, CachedEntity> getAllPresent(Iterable<?> iterable) {
                return ImmutableMap.of();
            }

            @Override
            public void put(Object o, CachedEntity cachedEntity) {

            }

            @Override
            public void putAll(Map<?, ? extends CachedEntity> map) {

            }

            @Override
            public void invalidate(Object o) {

            }

            @Override
            public void invalidateAll(Iterable<?> iterable) {

            }

            @Override
            public void invalidateAll() {

            }

            @Override
            public long size() {
                return 0;
            }

            @Override
            public CacheStats stats() {
                return null;
            }

            @Override
            public ConcurrentMap<Object, CachedEntity> asMap() {
                return new ConcurrentHashMap<>();
            }

            @Override
            public void cleanUp() {

            }
        };
    }
}
