package org.mwashi_mwale.authenticator.exception_handlers;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;
import reactor.core.publisher.Mono;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@Order(-2)
@Slf4j
@RequiredArgsConstructor
public class RestExceptionHandler implements WebExceptionHandler {

    private final ObjectMapper objectMapper;

    @NotNull
    @Override
    public Mono<Void> handle(@NotNull ServerWebExchange exchange, @NotNull Throwable ex) {
        if (ex instanceof WebExchangeBindException webExchangeBindException) {

            log.debug("errors:" + webExchangeBindException.getFieldErrors());
            var errors = new Errors("validation_failure", "Validation failed.");
            webExchangeBindException.getFieldErrors().forEach(e -> errors.add(e.getField(), e.getCode(), e.getDefaultMessage()));

            log.debug("handled errors::" + errors);
            try {
                exchange.getResponse().setStatusCode(HttpStatus.UNPROCESSABLE_ENTITY);
                exchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON);

                var db = new DefaultDataBufferFactory().wrap(objectMapper.writeValueAsBytes(errors));

                // write the given data buffer to the response
                // and return a Mono that signals when it's done
                return exchange.getResponse().writeWith(Mono.just(db));

            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return Mono.empty();
            }
        } else if (ex instanceof UserNotFoundException) {
            exchange.getResponse().setStatusCode(HttpStatus.NOT_FOUND);

            // marks the response as complete and forbids writing to it
            return exchange.getResponse().setComplete();
        }
        return Mono.error(ex);
    }
}

@Getter
@ToString
class Errors implements Serializable {
    private final String code;
    private final String message;
    private final List<Error> errors = new ArrayList<>();

    @JsonCreator
    Errors(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public void add(String path, String code, String message) {
        this.errors.add(new Error(path, code, message));
    }
}

@Getter
@ToString
class Error implements Serializable {
    private final String path;
    private final String code;
    private final String message;

    @JsonCreator
    Error(String path, String code, String message) {
        this.path = path;
        this.code = code;
        this.message = message;
    }

}
