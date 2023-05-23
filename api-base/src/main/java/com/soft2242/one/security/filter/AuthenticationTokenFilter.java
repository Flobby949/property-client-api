package com.soft2242.one.security.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.soft2242.one.security.cache.TokenStoreCache;
import com.soft2242.one.security.user.UserDetail;
import com.soft2242.one.security.utils.TokenUtils;

import java.io.IOException;

/**
 * Spring Security 默认不支持 token 认证，也不支持前后端分离
 * 通过新增过滤器，让 spring security 支持 token 认证
 * 然后把这个过滤器配置在 UsernamePasswordAuthenticationFilter 前面
 * @author : Flobby
 * @program : property-client-api
 * @description : 认证过滤器
 * @create : 2023-04-23 17:16
 **/
@Component
@AllArgsConstructor
public class AuthenticationTokenFilter extends OncePerRequestFilter {
    private final TokenStoreCache tokenStoreCache;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String accessToken = TokenUtils.getAccessToken(request);
        // accessToken为空，表示未登录
        if (StringUtils.isBlank(accessToken)) {
            chain.doFilter(request, response);
            return;
        }

        // 获取登录用户信息
        UserDetail user = tokenStoreCache.getUser(accessToken);
        if (user == null) {
            chain.doFilter(request, response);
            return;
        }

        // 用户存在
        Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

        // 新建 SecurityContext
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authentication);
        SecurityContextHolder.setContext(context);

        chain.doFilter(request, response);
    }
}
