package com.my.biz.common;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;

public class CharacterEncodingFilter extends HttpFilter implements Filter {
       
	private static final long serialVersionUID = 1L;
	private String encoding;

	public void init(FilterConfig fConfig) throws ServletException {
		encoding = fConfig.getInitParameter("encoding");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 서블릿이 실행되기 직전에 인코딩 처리한다.
		request.setCharacterEncoding(encoding);
		
		chain.doFilter(request, response);
	}

}
