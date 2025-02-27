package org.mwashi_mwale.authenticator.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.session.HeaderWebSessionIdResolver;
import org.springframework.web.server.session.WebSessionIdResolver;

@Configuration
public
class SessionConfig {
    public final static String xAuthToken = "X-AUTH-TOKEN";

    @Bean
    public WebSessionIdResolver webSessionIdResolver() {
        var resolver = new HeaderWebSessionIdResolver();
        resolver.setHeaderName(xAuthToken);
        return resolver;
    }
}
