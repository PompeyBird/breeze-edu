package org.bird.breeze.edu.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class WechatUtils {
    @Value("${wechat_appid}")
    private String appid;
    @Value("${wechat_appsecret}")
    private String appsecret;
    @Value("${wechat_token}")
    private String token;
    @Value("${wechat_host}")
    private String host;
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private HttpUtils httpUtils;

    private static final Logger log = LoggerFactory.getLogger(WechatUtils.class) ;

    /**
     * 获取用户详细信息
     */
    public final static String SCOPE_INFO = "snsapi_userinfo";
    /**
     * 近获取用户open_id
     */
    public final static String SCOPE_BASE = "snsapi_base";
    /**
     * 获取access_token 接口地址
     */
    private final static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    /**
     * 获取用户认证code
     */
    private final static String OAUTH_LOGIN_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
    /**
     * 获取网页授权登录access_token
     */
    private final static String OAUTH_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
    /**
     * 获取授权登录用户信息
     */
    private final static String OAUTH_WECHAT_USER_URL = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
    /**
     * 获取授权登录用户信息
     */
    private final static String JS_API_TICKET_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
    /**
     * access_token有效时间 时间有时间是7200 为了防止延时导致获取access_token的间断
     */
    private final static long EXPIRES_IN = 7100;
    /**
     * 当前access_token的KEY值
     */
    private static String ACCESS_TOKEN_KEY = "ACCESS_TOKEN_";
    /**
     * 当前access_token的KEY值
     */
    private static String JS_API_TICKET_KEY = "JS_API_TICKET_";
    /**
     * 当前access_token的KEY值
     */
    private static String REFRESH_AUTH_TOKEN_KEY = "REFRESH_AUTH_TOKEN_KEY_";
    /**
     * 用户信息的KEY值
     */
    private static String USER_INFO_KEY = "USER_INFO_KEY_";


    /***
     * 获取access_token
     * @return access_token
     */
    public String getAccessToken() throws IOException{

        String accessTokenKey = ACCESS_TOKEN_KEY + token;
        String accessToken = redisUtils.get(accessTokenKey);
        //当前没有获取access_token
        if (accessToken == null) {
            accessToken = refreshAccessToken();
            redisUtils.set(accessTokenKey, accessToken, EXPIRES_IN);
        }
        return accessToken;
    }

    /***
     * 刷新access_token
     * @return access_token
     */
    private String refreshAccessToken() throws IOException{
        String url = ACCESS_TOKEN_URL.replace("APPID", appid).replace("APPSECRET", appsecret);
        String result = httpUtils.get(url);
        JSONObject json = JSONObject.parseObject(result);
        String token = (String) json.get("access_token");
        if (token == null) {
            Integer errorCode = json.getInteger("errcode");
            String errorMsg = (String) json.get("errmsg");
            log.error("获取access_token失败:错误代码：" + errorCode + "错误信息：" + errorMsg);
        }
        return token;
    }

    /**
     * 获取授权登录access_token
     * @param code CODE
     * @return 网页授权access_token对象
     */
    private JSONObject getOAuthAccessToken(String code) throws IOException{
        String url = OAUTH_ACCESS_TOKEN_URL.replace("APPID", appid).replace("SECRET", appsecret).replace("CODE", code);
        String result = httpUtils.get(url);
        JSONObject json= JSONObject.parseObject(result);
        String token = json.getString("access_token");

        if(token == null){
            Integer errorCode = json.getInteger("errcode");
            String errorMsg = json.getString("errmsg");
            System.out.println(json.toString());
            log.error("获取授权登录access_token失败:错误代码：" + errorCode + "错误信息：" + errorMsg);
            return null;
        }

        return json;
    }

    /**
     * 获取用户信息
     * @param code CODE
     * @return 微信用户信息对象
     */
    public JSONObject getOAuthUserInfo(String code) throws IOException{
        JSONObject accessToken = getOAuthAccessToken(code);
        if (accessToken == null) {
            return null;
        }
        String token = accessToken.getString("access_token");
        String openid = accessToken.getString("openid");
        String url = OAUTH_WECHAT_USER_URL.replace("ACCESS_TOKEN", token).replace("OPENID", openid);
        String result = httpUtils.get(url);
        JSONObject jsonObject = JSONObject.parseObject(result);
        openid = jsonObject.getString("openid");

        if(openid == null){
            Integer errorCode = jsonObject.getInteger("errcode");
            String errorMsg = jsonObject.getString("errmsg");
            System.out.println(jsonObject.toString());
            log.error("获取access_token失败:错误代码：" + errorCode + "错误信息：" + errorMsg);
            return null;
        }

        return jsonObject;
    }

    public String getOAuthLoginUrl(String redirectUrl, String scope){
        return OAUTH_LOGIN_URL.replace("APPID", appid).replace("REDIRECT_URI", redirectUrl)
                .replace("SCOPE", scope);
    }

    /**
     * 利用openId缓存信息
     *
     * @param openId openId
     * @param content 保存的内容
     * @param expires 超时时间，单位秒
     */
    public void cacheInfoByOpenId(String openId, String content, long expires) {
        String openIdKey = openId + token;
        redisUtils.set(openIdKey, content, expires);
    }

    /**
     * 获得openId缓存的侵袭
     *
     * @param openId openId
     * @return 缓存的内容
     */
    public String getCachedInfoByOpenId(String openId){
        String openIdKey = openId + token;
        String content = redisUtils.get(openIdKey);
        return content;
    }

    /**
     * 微信回调验签
     *
     * @param signature signature
     * @param timestamp timestamp
     * @param nonce nonce
     * @return 验签是否通过
     */
    public boolean checkSignature(String signature, String timestamp, String nonce) {
        String[] arr = new String[] { token, timestamp, nonce };
        // 将token、timestamp、nonce三个参数进行字典序排序
        sort(arr);
        StringBuilder content = new StringBuilder();
        for (String anArr : arr) {
            content.append(anArr);
        }
        MessageDigest md;
        String tmpStr = null;

        try {
            md = MessageDigest.getInstance("SHA-1");
            // 将三个参数字符串拼接成一个字符串进行sha1加密
            byte[] digest = md.digest(content.toString().getBytes());
            tmpStr = byteToStr(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        // 将sha1加密后的字符串可与signature对比，标识该请求来源于微信
        return tmpStr != null && tmpStr.equals(signature.toUpperCase());
    }

    /**
     * 将字节数组转换为十六进制字符串
     *
     * @param byteArray 字节数组
     * @return 十六进制字符串
     */
    private String byteToStr(byte[] byteArray) {
        StringBuilder strDigest = new StringBuilder();
        for (byte aByteArray : byteArray) {
            strDigest.append(byteToHexStr(aByteArray));
        }
        return strDigest.toString();
    }

    /**
     * 将字节转换为十六进制字符串
     *
     * @param mByte 十六进制字节
     * @return 字符串
     */
    private String byteToHexStr(byte mByte) {
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];
        String s = new String(tempArr);
        return s;
    }
    private static void sort(String a[]) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[j].compareTo(a[i]) < 0) {
                    String temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    /***
     * 获取access_token
     * @return access_token
     */
    public String getJsApiTicket() throws IOException{

        String jsApiTicketKey = JS_API_TICKET_KEY + token;
        String jsApiTicket = redisUtils.get(jsApiTicketKey);
        //当前没有获取access_token
        if (jsApiTicket == null) {
            jsApiTicket = refreshJsApiTicket();
            redisUtils.set(jsApiTicketKey, jsApiTicket, EXPIRES_IN);
        }
        return jsApiTicket;
    }

    private String refreshJsApiTicket() throws IOException{
        String accessToken = getAccessToken();
        String url = JS_API_TICKET_URL.replace("ACCESS_TOKEN", accessToken);
        String result = httpUtils.get(url);
        JSONObject json = JSONObject.parseObject(result);
        String jsapi_ticket = (String) json.get("ticket");
        if (token == null) {
            Integer errorCode = (Integer) json.get("errcode");
            String errorMsg = (String) json.get("errmsg");
            log.error("获取jsapi_ticket失败:错误代码：" + errorCode + "错误信息：" + errorMsg);
        }
        return jsapi_ticket;
    }

    public Map<String, String> getSignature(String jsapi_ticket, String url) {
        Map<String, String> ret = new HashMap<String, String>();
        String nonce_str = create_nonce_str();
        String timestamp = create_timestamp();
        String string1;
        String signature = "";

        //注意这里参数名必须全部小写，且必须有序
        string1 = "jsapi_ticket=" + jsapi_ticket +
                "&noncestr=" + nonce_str +
                "&timestamp=" + timestamp +
                "&url=" + url;
        System.out.println(string1);

        try
        {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(string1.getBytes("UTF-8"));
            signature = byteToHex(crypt.digest());
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }

        ret.put("url", url);
        ret.put("jsapi_ticket", jsapi_ticket);
        ret.put("nonceStr", nonce_str);
        ret.put("timestamp", timestamp);
        ret.put("signature", signature);

        return ret;
    }

    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    private static String create_nonce_str() {
        return UUID.randomUUID().toString();
    }

    private static String create_timestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAppsecret() {
        return appsecret;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
