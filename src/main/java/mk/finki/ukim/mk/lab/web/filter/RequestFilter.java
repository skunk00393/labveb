package mk.finki.ukim.mk.lab.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter
public class RequestFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)  servletRequest;
        HttpServletResponse response = (HttpServletResponse)  servletResponse;
        String balloonColor = (String) request.getSession().getAttribute("balloonColor");
        String path = request.getServletPath();
        if(!path.equals("/balloons")&&!path.equals("/balloons/add-form")&&!path.equals("/balloons/add")&&!path.contains("/balloons/edit-form")&&!path.equals("/balloons/edit")&&!path.contains("/balloons/delete")&&balloonColor == null){
            request.getSession().invalidate();
            response.sendRedirect("/balloons");
        }
        else{
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
