package com.fangdd.mobile.data.general.cache;

import android.content.Context;

import com.fangdd.mobile.domin.general.cache.GeneralCache;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by lee on 17/2/14.
 */
@Singleton
public class GeneralDataCache extends BaseCache implements GeneralCache {


    final String USER_ID = "user_id";
    final String USER_NAME = "user_name";
    final String USER_TOKEN = "user_token";

    @Inject
    public GeneralDataCache(Context context) {
        super(context);
    }

    @Override
    public void setUserId(Long userId) {
        setLong(USER_ID, userId);
    }

    @Override
    public Long getUserId() {
        return getLong(USER_ID);
    }

    @Override
    public void setUserName(String userName) {
        cache.put(USER_NAME, userName);
    }

    @Override
    public String getUserName() {
        return cache.getAsString(USER_NAME);
    }

    @Override
    public void setToken(String token) {
        cache.put(USER_TOKEN, token);
    }

    @Override
    public String getToken() {
        return cache.getAsString(USER_TOKEN);
    }


}
