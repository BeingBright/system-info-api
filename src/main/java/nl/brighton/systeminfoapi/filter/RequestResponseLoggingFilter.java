package nl.brighton.systeminfoapi.filter;

import nl.brighton.systeminfoapi.service.MemoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@Order(2)
public class RequestResponseLoggingFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(MemoryService.class);

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        LOGGER.info("'{}' Request on endpoint: '{} @ {}'", req.getMethod(), req.getRequestURI(), req.getRemoteAddr());
        chain.doFilter(request, response);
    }
}