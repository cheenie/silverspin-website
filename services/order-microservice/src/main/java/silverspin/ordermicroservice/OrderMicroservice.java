package silverspin.ordermicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({
        "silverspin.ordermicroservice.api",
        "silverspin.ordermicroservice.dto",
        "silverspin.ordermicroservice.entity",
        "silverspin.ordermicroservice.repo",
        "silverspin.ordermicroservice.service",
})
public class OrderMicroservice {

    public static void main(String[] args) {
        SpringApplication.run(OrderMicroservice.class, args);
    }

}