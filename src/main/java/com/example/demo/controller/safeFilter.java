package com.example.demo.controller;

import com.example.demo.exception.BizException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/*
 *  @author huajishaonian
        *  time : 2020-06-2020/6/10-2:28 下午
        *
        */

@WebFilter(urlPatterns = "/*")
public class safeFilter implements javax.servlet.Filter {

    final String judgeURI1 = "/login/user";
    final String judgeURI2 = "/login/creatAccount";

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws ServletException, IOException {

        String URI = ((HttpServletRequest) req).getRequestURI();
        /*
         * 首先过滤登录URL
         * */
        Boolean allow = URI.equals(judgeURI1) || URI.equals(judgeURI2);
        if (allow) {
            chain.doFilter(req, resp);
        } else {
            try {
                /*查询session里有没有登录时写进去的东西，没有则为非法登录*/
                /*未登录不分配session，捕捉异常*/
                HttpSession session = ((HttpServletRequest) req).getSession();
                boolean judge = session.getAttribute("USER").equals(null) || "".equals(session.getAttribute("USER"));
                if (judge) {
                    throw new BizException("400", "非法登录.");
                } else {
                    chain.doFilter(req, resp);
                }
            } catch (Exception e) {
                throw new BizException("400", "非法登录.");
            }
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
