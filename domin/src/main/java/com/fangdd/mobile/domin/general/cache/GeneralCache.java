package com.fangdd.mobile.domin.general.cache;

/**
 * A cache interface to set and get general information. Created by lee on 17/2/14.
 */

public interface GeneralCache {

    /**
     * save the id
     * @param userId the id of the user current use this app.
     */
    void setUserId(Long userId);

    /**
     * @return the id of the user current use this app.
     */
    Long getUserId();

    /**
     * @param userName the name of the user current use this app.
     */
    void setUserName(String userName);

    /**
     * @return the name of the user current use this app.
     */
    String getUserName();

    /**
     * @param token the token of the user current use this app.
     */
    void setToken(String token);

    /**
     * @return the token of the user current use this app.
     */
    String getToken();

}
