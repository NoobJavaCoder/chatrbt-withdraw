package net.monkeystudio.chatrbtw.service;

import net.monkeystudio.base.exception.BizException;
import net.monkeystudio.base.redis.RedisCacheTemplate;
import net.monkeystudio.base.redis.constants.RedisTypeConstants;
import net.monkeystudio.base.utils.DateUtils;
import net.monkeystudio.chatrbtw.entity.WxFan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xiaxin
 */
@Service
public class SessionTokenService {
    //token失效时间
    public final static Integer SESSION_TOKEN_EXPIRE = 3600 * 2 ;

    @Autowired
    private RedisCacheTemplate redisCacheTemplate;

    @Autowired
    private WxFanService wxFanService;

    /**
     * 获取redis sesion的key值
     * @param token
     * @return
     */
    public String getSessionTokenCacheKey(String token){
        return RedisTypeConstants.KEY_STRING_TYPE_PREFIX + "miniProgramSessionToken:" + token;
    }

    public void saveToken(String token,Integer miniProgramId,String wxFanOpenId,String sessionKey){
        String key = this.getSessionTokenCacheKey(token);

        String value = miniProgramId + ":" + wxFanOpenId + ":" + sessionKey;

        Integer remainSecond = DateUtils.getCacheSeconds();//距离第二天凌晨多少秒

        Integer cacheSecond = SESSION_TOKEN_EXPIRE;

        redisCacheTemplate.setString(key,value);

        //如果距离第二天凌晨小于2小时,token失效时间为距离凌晨的时间,保证每天都会刷新token,用于判断用户每天第一次登录.
        if(remainSecond.intValue() < cacheSecond.intValue()){
            cacheSecond = remainSecond;
        }

        redisCacheTemplate.expire(key,cacheSecond);
    }

    public String getTokenValue(String token){
        String sessionTokenCacheKey = this.getSessionTokenCacheKey(token);
        String value = redisCacheTemplate.getString(sessionTokenCacheKey);
        return value;
    }

    public String getSessionKeyFromTokenVal(String token){
        String sessionTokenCacheKey = this.getSessionTokenCacheKey(token);
        String value = redisCacheTemplate.getString(sessionTokenCacheKey);
        return value.split(":")[2];
    }

    public String getOpenIdFromTokenVal(String token){
        String sessionTokenCacheKey = this.getSessionTokenCacheKey(token);
        String value = redisCacheTemplate.getString(sessionTokenCacheKey);
        return value.split(":")[1];
    }

    public Integer getMiniProgramIdFromTokenVal(String token){
        String sessionTokenCacheKey = this.getSessionTokenCacheKey(token);
        String value = redisCacheTemplate.getString(sessionTokenCacheKey);
        String miniProgramIdStr = value.split(":")[0];
        return Integer.parseInt(miniProgramIdStr);
    }

    public Integer getWxFanIdByToken(String token){
        Integer miniProgramId = this.getMiniProgramIdFromTokenVal(token);
        String wxFanOpenId = this.getOpenIdFromTokenVal(token);
        WxFan wxFan = wxFanService.getWxFan(wxFanOpenId, miniProgramId);
        if(wxFan != null){
            return wxFan.getId();
        }
        return null;
    }



}
