package org.erp.myproductionsrc.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.ehcache.EhCacheManager;

import java.util.concurrent.atomic.AtomicInteger;

public class RetryLimitCredetialsMatcher extends HashedCredentialsMatcher {

    private Cache<String, AtomicInteger> passwordRetryCache;

    /*public RetryLimitCredetialsMatcher(EhCacheManager cacheManager){
        passwordRetryCache = cacheManager.getCache("passwordRetryCache");
    }*/

    public RetryLimitCredetialsMatcher(CacheManager cacheManager) {
        passwordRetryCache = cacheManager.getCache("passwordRetryCache");
    }
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info){



        String username = (String)token.getPrincipal();
        AtomicInteger retrycount = passwordRetryCache.get(username);
        if(null == retrycount){
            retrycount = new AtomicInteger(0);
            passwordRetryCache.put(username,retrycount);
        }
        if(retrycount.incrementAndGet() > 3){
            throw new ExcessiveAttemptsException();
        }
        boolean match = super.doCredentialsMatch(token,info);
        if(match){
            passwordRetryCache.remove(username);
        }
        return match;
    }
}
