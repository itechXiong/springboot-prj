package com.xitech.app.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@SpringBootApplication
//@RestController
//@RequestMapping("/gateway")
public class XitechGatewayApp 
{
    public static void main( String[] args )
    {
        /*System.out.println( "Hello World!" );*/
    	SpringApplication.run(XitechGatewayApp.class, args);
    }
    
   /* @RequestMapping("/test")
    public String gatewayTest() {
    	return "test";
    }*/
}
