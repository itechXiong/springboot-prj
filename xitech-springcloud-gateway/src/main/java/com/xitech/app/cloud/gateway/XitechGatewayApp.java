package com.xitech.app.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

/**
 * Hello world!
 *
 */
@SpringBootApplication
//@EnableDiscoveryClient
//@RestController
//@RequestMapping("/gateway")
public class XitechGatewayApp 
{
	/*@Bean
	public RouteLocator testRouteLocator(RouteLocatorBuilder builder) {//filters(f -> f.addRequestHeader("X-Request-Acme", "ValueB"))http://localhost:8088/hystrixFeignApi/content/header
		return builder.routes()
				.route("add_request_header_route", r ->r.path("/test").filters(f -> f.addRequestHeader("X-Request-Acme", "ValueB"))
								.uri("http://localhost:8080/test/head"))
				.build();
	}*/
    public static void main( String[] args )
    {
        /*System.out.println( "Hello World!" );*/
    	SpringApplication.run(XitechGatewayApp.class, args);
    }
}
