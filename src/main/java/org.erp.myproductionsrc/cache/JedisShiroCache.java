package org.erp.myproductionsrc.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.erp.myproductionsrc.Util.JedisUtils;
import org.erp.myproductionsrc.Util.SerializeUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

public class JedisShiroCache<K, V> implements Cache<K, V> {
/*
    //private JedisManager jedisManager;

    private JedisPool jedisPool;



    private Jedis jedis;

    public JedisShiroCache(){

        this.jedis = jedisPool.getResource();
    }
*/
    private static final String REDIS_SHIRO_CACHE = "shiro-demo-cache:";

    private String name;

    public String getName() {
        if (name == null)
            return "";
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public V  get(K key) throws CacheException {

        byte[] bs = SerializeUtils.serialize(buildCacheKey(key));

        byte[] value = JedisUtils.getJedis().get(bs);

        if(value == null){
            return null;
        }
        return (V)SerializeUtils.deserialize(value);
    }

    public V put(K key, V value) throws CacheException {
        Jedis jedis = JedisUtils.getJedis();
        String mykey = buildCacheKey(key);
        jedis.set(SerializeUtils.serialize(mykey),SerializeUtils.serialize(value));
        return null;
    }

    public V remove(K key) throws CacheException {
        return null;
    }

    public void clear() throws CacheException {

    }

    public int size() {
        return 0;
    }

    public Set keys() {
        return null;
    }

    public Collection values() {
        return null;
    }

    private String buildCacheKey(Object key) {
        return REDIS_SHIRO_CACHE + getName() + ":" + key;
    }
}
