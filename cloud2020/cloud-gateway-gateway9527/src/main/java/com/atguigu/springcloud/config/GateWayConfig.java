package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customRouteLocator( RouteLocatorBuilder locatorBuilder ){
        RouteLocatorBuilder.Builder routes = locatorBuilder.routes();
        routes.route("luyou_yhp",
                r -> r.path("/guonei").uri("https://www.bilibili.com/video/BV18E411x7eT?p=70")).build();

        return routes.build();
    }

}
