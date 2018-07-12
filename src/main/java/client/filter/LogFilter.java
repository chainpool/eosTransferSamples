package client.filter;

import client.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lxg on 2017/3/29.
 *
 * @desc 日志拦截器
 */
@WebFilter(filterName = "logFilter", urlPatterns = "/*")
public class LogFilter implements Filter {
    static final String ORIGIN = "Origin";
    private final LLogger logger = LLoggerFactory.getLogger("filterLogger");

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        RequestWrapper requestWrapper = null;
        try {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            requestWrapper = new RequestWrapper(request);
            ThreadLocalUtils.remove();
            String ip = Utils.getIpAddress(request);
            String url = request.getRequestURL().toString();
            String method = request.getMethod();
            String uuid = Utils.getFullDate() + Utils.getRandNumber();
            ThreadLocalUtils.set(uuid);
            String contentType = request.getContentType();
            String origin = request.getHeader(ORIGIN);

            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
            if (request.getMethod().equals("OPTIONS")) {
                response.setStatus(HttpServletResponse.SC_OK);
            }
            String requestBody = RequestWrapper.getBodyString(requestWrapper);
            logger.info("ip: {}, url: {}, contentType: {}, requestMethod: {}, requestBody: {}", ip, url, contentType, method, requestBody);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        filterChain.doFilter(requestWrapper, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
