package com.github.axonmulti.person;

import org.axonframework.springboot.autoconfig.AxonServerAutoConfiguration;
import org.axonframework.springboot.autoconfig.JdbcAutoConfiguration;
import org.axonframework.springboot.autoconfig.JpaAutoConfiguration;
import org.axonframework.springboot.autoconfig.JpaEventStoreAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

// We are not using event sourcing, so do not include repositories for event store and event tracking
@SpringBootApplication(scanBasePackages = {"com.github.axonmulti.common", "com.github.axonmulti.person"},
        exclude = {ErrorMvcAutoConfiguration.class
                , AxonServerAutoConfiguration.class
                , JpaEventStoreAutoConfiguration.class
                , JpaAutoConfiguration.class
                , JdbcAutoConfiguration.class
})

@EnableEurekaClient
public class PersonSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonSpringBootApplication.class, args);
    }

}
