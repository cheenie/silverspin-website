package silverspin.shippingmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({
        "silverspin.shippingmicroservice.api",
        "silverspin.shippingmicroservice.dto",
        "silverspin.shippingmicroservice.entity",
        "silverspin.shippingmicroservice.repo",
        "silverspin.shippingmicroservice.service",
})
public class ShippingMicroservice {

    public static void main(String[] args) {
        SpringApplication.run(ShippingMicroservice.class, args);
    }

}
