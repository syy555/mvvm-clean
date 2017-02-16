package com.fangdd.mobile.data.general.cache;

import android.content.Context;
import android.text.TextUtils;

/**
 * Created by lee on 17/2/14.
 */

public class BaseCache {

    ACache cache;

    BaseCache(Context context) {
        cache = ACache.get(context);
    }

    /**
     * save Long to cache
     *
     * @param key   the key to find the saved value
     * @param value Long value need to be saved
     */
    protected void setLong(String key, Long value) {
        if (value == null) {
            cache.put(key + "_Long", "null");
        } else {
            cache.put(key + "_Long", String.valueOf(value));
        }
    }

    /**
     * get Long from cache
     *
     * @param key the key to find the saved value
     * @return the saved Long value
     */
    protected Long getLong(String key) {
        String tmp = cache.getAsString(key + "_Long");
        if (TextUtils.isEmpty(tmp)) {
            return null;
        }
        return Long.parseLong(tmp);
    }

    /**
     * save Integer to cache
     *
     * @param key   the key to find the saved value
     * @param value Integer value need to be saved
     */
    protected void setInt(String key, Integer value) {
        if (value == null) {
            cache.put(key + "_Integer", "null");
        } else {
            cache.put(key + "_Integer", String.valueOf(value));
        }
    }

    /**
     * get Integer from cache
     *
     * @param key the key to find the saved value
     * @return the saved Integer value
     */
    protected Integer getInt(String key) {
        String tmp = cache.getAsString(key + "_Integer");
        if (TextUtils.isEmpty(tmp)) {
            return null;
        }
        return Integer.parseInt(tmp);
    }

    /**
     * save Double to cache
     *
     * @param key   the key to find the saved value
     * @param value Double value need to be saved
     */
    protected void setDouble(String key, Double value) {
        if (value == null) {
            cache.put(key + "_Double", "null");
        } else {
            cache.put(key + "_Double", String.valueOf(value));
        }
    }

    /**
     * get Integer from cache
     *
     * @param key the key to find the saved value
     * @return the saved Double value
     */
    protected Double getDouble(String key) {
        String tmp = cache.getAsString(key + "_Double");
        if (TextUtils.isEmpty(tmp)) {
            return null;
        }
        return Double.parseDouble(tmp);
    }

    /**
     * save Boolean to cache
     *
     * @param key   the key to find the saved value
     * @param value Boolean value need to be saved
     */
    protected void setBoolean(String key, Boolean value) {
        if (value == null) {
            cache.put(key + "_Boolean", "null");
        } else {
            cache.put(key + "_Boolean", String.valueOf(value));
        }
    }

    /**
     * get Boolean from cache
     *
     * @param key the key to find the saved value
     * @return the saved Boolean value
     */
    protected Boolean getBoolean(String key) {
        String tmp = cache.getAsString(key + "_Boolean");
        if (TextUtils.isEmpty(tmp)) {
            return null;
        }
        return Boolean.parseBoolean(tmp);
    }
}
