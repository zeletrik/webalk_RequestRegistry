package hu.me.zelena.rr.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {    
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);
        String loginURI = request.getContextPath() + "/login";
        String requestURI =  request.getRequestURI();
        
        boolean loggedIn = session != null;   
        
        if (loggedIn) {
        	if (requestURI.equals(loginURI)){
        		System.out.println(session.getAttributeNames());
        	}
        	chain.doFilter(request, response);
        } else {
        	System.out.println(session.getAttributeNames());
        	request.getRequestDispatcher("/login").forward(request, response); 
        }
    }

	public void destroy() {
		// TODO Auto-generated method stub	
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub	
	}

}
