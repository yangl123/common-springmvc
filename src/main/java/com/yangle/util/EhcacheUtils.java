package com.yangle.util;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class EhcacheUtils {
    private static CacheManager cacheManager = null;

    static {
        intEhcacheManager();

    }

    private static void intEhcacheManager() {
        cacheManager = CacheManager.getInstance().create("/ehcache.xml");
        setValue("aaa",1111);
        setValue("bbb",222);
        setValue("ddd",333);
        setValue("ccc",444);
    }


    public static void setValue2(String cacheName, String key, Object value) {
        if (cacheManager == null) {
            intEhcacheManager();
        }
        Cache cache = cacheManager.getCache(cacheName);
        Element element = new Element(key, value);
        cache.put(element);
    }


    public static void setValue(String key, Object value) {
        if (cacheManager == null) {
            intEhcacheManager();
        }
        Cache cache = cacheManager.getCache("myCache");
        Element element = new Element(key, value);
        cache.put(element);
    }


    public static Object getValue(String key) {
        if (cacheManager == null) {
            intEhcacheManager();
        }
        Cache cache = cacheManager.getCache("myCache");
        Element element = cache.get(key);
        if (element == null) {
            return null;
        }
        return element.getObjectValue();
    }

    public static Object getValue2(String cacheName, String key) {
        if (cacheManager == null) {
            intEhcacheManager();
        }
        Cache cache = cacheManager.getCache(cacheName);
        Element element = cache.get(key);
        if (element == null) {
            return null;
        }
        return element.getObjectValue();
    }

    public static void main(String[] args) {

    }
}
