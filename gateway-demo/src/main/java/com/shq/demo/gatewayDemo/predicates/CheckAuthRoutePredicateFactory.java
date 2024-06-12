package com.shq.demo.gatewayDemo.predicates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * 自定义路由断言工厂
 */
@Component
public class CheckAuthRoutePredicateFactory extends AbstractRoutePredicateFactory<CheckAuthRoutePredicateFactory.Config> {

    public final static Logger log = LoggerFactory.getLogger(CheckAuthRoutePredicateFactory.class);

    public CheckAuthRoutePredicateFactory() {
        super(Config.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(CheckAuthRoutePredicateFactory.Config config) {
        return exchange -> {
            log.info("调用了自定义路由断言工厂CheckAuthRoutePredicateFactory");
            List<String> values = exchange.getRequest().getHeaders()
                    .getOrDefault("auth", Collections.emptyList());
            if (values.isEmpty()) {
                return false;
            }
            return values.stream().anyMatch(c -> c.equals(config.getName()));
        };
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("name");
    }

    @Validated
    public static class Config {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
