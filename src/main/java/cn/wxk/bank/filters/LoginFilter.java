package cn.wxk.bank.filters;

import cn.wxk.bank.beans.LoginBean;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",urlPatterns = {"/secured/*"})
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Nothing to do here!
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // Get the loginBean from session attribute
        LoginBean loginBean = (LoginBean)((HttpServletRequest)request).getSession().getAttribute("loginBean");

        // For the first application request there is no loginBean in the session so user needs to log in
        // For other requests loginBean is present but we need to check if user has logged in successfully
        if (loginBean == null || !loginBean.isLoggedIn()) {
            String contextPath = ((HttpServletRequest)request).getContextPath();
            ((HttpServletResponse)response).sendRedirect(contextPath + "/login.xhtml");
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Nothing to do here!
    }
}
