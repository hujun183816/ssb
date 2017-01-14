package com.libo.util;


import net.sf.json.JSONException;
import net.sf.json.JSONObject;
/**
 * 获取openid
 * @author 胡俊
 *	2016年9月28日 上午12:34:28
 */
public class OpenIdUtil {
	public static String getOAuthOpenId(String appid, String secret, String code ) {
        String openid = null;
        String o_auth_openid_url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code;";
        String requestUrl = o_auth_openid_url.replace("APPID", appid).replace("SECRET", secret).replace("CODE", code);
       
        JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
        
        //oAuthInfo是作者自己把那几个属性参数写在一个类里面了。
        // 如果请求成功
        if (null != jsonObject) {
            try {
                openid=jsonObject.getString("openid");
            } catch (JSONException e) {
                // 获取token失败
            }
        }
        return openid;
    }
}
