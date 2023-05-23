package com.soft2242.one.security.cache;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import com.soft2242.one.common.cache.RedisCache;
import com.soft2242.one.common.cache.RedisKeys;
import com.soft2242.one.security.user.UserDetail;

 /**
 * @author : Flobby
 * @program : property-client-api
 * @description : 登录用户的缓存操作
 * @create : 2023-04-23 17:16
 **/
@Component
@AllArgsConstructor
public class TokenStoreCache {

    private final RedisCache redisCache;

    public void saveUser(String accessToken, UserDetail user) {
        String key = RedisKeys.getAccessTokenKey(accessToken);
        redisCache.set(key, user);
    }

    public UserDetail getUser(String accessToken) {
        String key = RedisKeys.getAccessTokenKey(accessToken);
        return (UserDetail) redisCache.get(key);
    }

    public void deleteUser(String accessToken) {
        String key = RedisKeys.getAccessTokenKey(accessToken);
        redisCache.delete(key);
    }
}
