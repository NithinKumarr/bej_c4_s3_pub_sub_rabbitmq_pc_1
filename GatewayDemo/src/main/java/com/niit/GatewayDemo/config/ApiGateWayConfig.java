package com.niit.GatewayDemo.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGateWayConfig {

        @Bean
        public RouteLocator getRoutes(RouteLocatorBuilder builder){
            return builder.routes().
                    route(p->p.path("/api/productservice/**").uri("http://localhost:65110/")).
                    route(p->p.path("/api/userService/**").uri("http://localhost:8039/")).build();
        }
//        return builder.routes().
//                route(p->p.path("/api/productservice/**").uri("lb://Product-Services")).
//                route(p->p.path("/api/userService/**").uri("lb://User-service")).build();
    }

