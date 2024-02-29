package ee.decathlon_calculator.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.UUID;

import static ee.decathlon_calculator.utils.Constants.SESSION_ID_HEADER;

@Component
@Slf4j
public class RequestFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String sessionId = httpRequest.getHeader(SESSION_ID_HEADER);
        if (sessionId == null || sessionId.isEmpty()) {
            sessionId = UUID.randomUUID().toString();
        }
        request.setAttribute(SESSION_ID_HEADER, sessionId);
        log.info("request - {}", ((HttpServletRequest) request).getPathInfo());
        chain.doFilter(request, response);
    }
}