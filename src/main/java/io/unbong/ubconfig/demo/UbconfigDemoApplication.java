package io.unbong.ubconfig.demo;

import io.unbong.ubconfig.client.annotation.EnableUbConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableConfigurationProperties({UbDemoConfig.class})
@EnableUbConfig
@RestController
public class UbconfigDemoApplication {

    @Value("${ub.a}")
    private String a;

    @Value("${ub.b}")
    private String b;

    @Value("${ub.c}")
    private String c;

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

    @GetMapping("/demo")
    public String hello(){
        return "ub.a = " + a + "\n" +
                "ub.b = " + b + "\n" +
                "demo.a = " + config.getA() + "\n"+
                "demo.b = " + config.getB() + "\n";
    }
}
