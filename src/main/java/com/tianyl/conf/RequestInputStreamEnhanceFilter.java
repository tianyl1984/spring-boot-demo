package com.tianyl.conf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ReadListener;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.springframework.stereotype.Component;

/**
 * 增强request中的InputStream，使其支持多次读取
 * 
 * @author user
 *
 */
@Component
public class RequestInputStreamEnhanceFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		final ByteArrayInputStream bais = new ByteArrayInputStream(read(request.getInputStream()));
		HttpServletRequestWrapper wrapper = new HttpServletRequestWrapper(request) {

			@Override
			public ServletInputStream getInputStream() throws IOException {
				return new ServletInputStream() {

					@Override
					public int read() throws IOException {
						return bais.read();
					}

					@Override
					public void setReadListener(ReadListener listener) {
						throw new RuntimeException("setReadListener not supported");
					}

					@Override
					public boolean isReady() {
						return true;
					}

					@Override
					public boolean isFinished() {
						return bais.available() == 0;
					}

					@Override
					public synchronized void reset() throws IOException {
						bais.reset();
					}

					@Override
					public boolean markSupported() {
						return bais.markSupported();
					}
				};
			}

		};
		chain.doFilter(wrapper, response);
	}

	private byte[] read(ServletInputStream inputStream) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] bs = new byte[1024];
		int hasRead = -1;
		while ((hasRead = inputStream.read(bs)) != -1) {
			baos.write(bs, 0, hasRead);
		}
		return baos.toByteArray();
	}

	@Override
	public void destroy() {

	}

}
