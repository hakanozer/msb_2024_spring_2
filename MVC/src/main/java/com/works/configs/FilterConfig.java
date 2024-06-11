package com.works.configs;

import com.works.entities.Customer;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class FilterConfig implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String url = request.getRequestURI();
        String[] freeUrls = {"/", "/userLogin"};
        boolean loginStatus = true;
        for (String freeUrl : freeUrls) {
            if (url.equals(freeUrl)) {
                loginStatus = false;
            }
        }

        if (loginStatus) {
            // session control
            Object obj = request.getSession().getAttribute("customer");
            if (obj != null) {
                Customer customer = (Customer) obj;
                request.setAttribute("customer", customer);
                filterChain.doFilter(request, response);
            }else {
                // session null
                response.sendRedirect(request.getContextPath() + "/");
            }
        }else {
            filterChain.doFilter(request, response);
        }

    }

}
