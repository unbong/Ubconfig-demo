package io.unbong.ubconfig.demo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Description
 *
 * @author <a href="ecunbong@gmail.com">unbong</a>
 * 2024-05-05 10:14
 */
@Data
@ConfigurationProperties(prefix = "ub")
public class UbDemoConfig {

    String a;

    String b;

}
