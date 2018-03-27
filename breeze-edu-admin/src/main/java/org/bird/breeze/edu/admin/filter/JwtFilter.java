package org.bird.breeze.edu.admin.filter;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.bird.breeze.edu.utils.SpringContext;
import org.bird.breeze.edu.bean.common.BreezeResult;
import org.bird.breeze.edu.constants.MemberConstants;
import org.bird.breeze.edu.utils.JwtUtils;
import org.bird.breeze.edu.utils.PatternUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.regex.Pattern;

/**
 * @author pompey
 */
public class JwtFilter extends OncePerRequestFilter {

    private static final String METHOD_OPTIONS = "OPTIONS";
    private final static Logger logger = LoggerFactory.getLogger(JwtFilter.class);

    private String exceptUrlRegex;
    private Pattern exceptUrlPattern;

    public void setExceptUrlRegex(String exceptUrlRegex) {
        this.exceptUrlRegex = exceptUrlRegex;
    }

    private JwtUtils jwtUtils;
    private PatternUtils patternUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {


        //这里填写你允许进行跨域的主机ip
        response.setHeader("Access-Control-Allow-Origin", "*");
        //允许的访问方法
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE, PATCH");
        //Access-Control-Max-Age 用于 CORS 相关配置的缓存
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization, ReAuthorization");
        response.setHeader("Access-Control-Expose-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization, ReAuthorization");

        if (METHOD_OPTIONS.equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            chain.doFilter(request, response);
            return ;
        }

        if(null == exceptUrlPattern){
            this.jwtUtils = SpringContext.getBean(JwtUtils.class);
            this.patternUtils = SpringContext.getBean(PatternUtils.class);
            if(StringUtils.isNotEmpty(exceptUrlRegex)){
                exceptUrlPattern = patternUtils.build(exceptUrlRegex);
            }
            logger.debug("==========get bean============");
        }

        String servletPath = request.getServletPath();
        if (exceptUrlPattern.matcher(servletPath).matches()) {
            chain.doFilter(request, response);
            return;
        }

        //等到请求头信息authorization信息
        String token = null;
        String authHeader = request.getHeader("Authorization");
        authHeader= URLDecoder.decode(authHeader,"UTF-8");
        if (authHeader != null && authHeader.startsWith("Bearer|")) {
            token = authHeader.substring(7);
        }

        if(!StringUtils.isEmpty(token)){
            final Claims claims = jwtUtils.parseJWT(token);
            if(claims != null){
                String newToken = jwtUtils.checkExprieAndUpdate(claims);
                if(newToken != null) {
                    response.addHeader("ReAuthorization", "Bearer|" + newToken);
                }
                request.setAttribute(MemberConstants.USER_CLAIMS, claims);
                chain.doFilter(request, response);
                return;
            }
        }

        BreezeResult<Object> result = new BreezeResult<Object>("尚未登录！");
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(JSONObject.toJSONString(result, SerializerFeature.WriteMapNullValue));
    }
}
