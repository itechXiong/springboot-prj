package com.xitech.app.customer;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.xitech.app.interfaced.XitechDubboPrint;

@EnableAutoConfiguration
//@SpringBootApplication
public class XitechSpringbootDubboCustomerApp 
{
	
	@Reference(version = "1.0.0", url = "dubbo://127.0.0.1:9999")
    private XitechDubboPrint printService;
	
    public static void main( String[] args )
    {
        SpringApplication.run(XitechSpringbootDubboCustomerApp.class, args).close();
    }
    
    @Bean
    public ApplicationRunner runner() {
        return args -> {
            printService.printMethod("mercyblitz");
        };
    }
    
    /*@Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("xitech-springboot-dubbo-customer");
        return applicationConfig;
    }*/

}
