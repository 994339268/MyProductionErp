package org.erp.myproductionsrc.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

public class ShiroRedisCacheManager implements CacheManager {
    public <K, V> Cache<K, V> getCache(String s) throws CacheException {
        return new JedisShiroCache();
    }
}
