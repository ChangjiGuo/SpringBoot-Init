package com.ly.ysmr.framework.filter;

import com.ly.ysmr.framework.config.CommonConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * description:
 *
 * @author changji.guo
 * @date 2020/4/26 15:45
 */

@Order(1)
@WebFilter(urlPatterns = "/api/*", filterName = "secretFilter")
public class YsmrFilter implements Filter {

    @Autowired
    public CommonConfig config;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //设置相应报文
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");

        //访问权限校验
        String method = request.getMethod();
        if ("OPTIONS".equals(method)) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            //获取传入的secret
            String secret = request.getHeader("client-secret");
            if (!config.getSecretCode().equals(secret)) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, String.format("校验secretCode错误，%s:%s",
                    "client-secret", secret));
                return;
            }
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
