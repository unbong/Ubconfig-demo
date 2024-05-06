package io.unbong.ubconfig.demo;

import io.unbong.ubconfig.client.annotation.EnableUbConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties({UbDemoConfig.class})
@EnableUbConfig
public class UbconfigDemoApplication {

    @Value("${ub.a}")
    private String a;

    @Autowired
    private UbDemoConfig config;


    public static void main(String[] args) {
        SpringApplication.run(UbconfigDemoApplication.class, args);
    }


    @Bean
    ApplicationRunner applicationRunner(){
        return arguments->{
            System.out.println(a);
            System.out.println(config.getA());
        };
    }
}
