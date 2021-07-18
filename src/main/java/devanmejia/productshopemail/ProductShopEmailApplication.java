package devanmejia.productshopemail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProductShopEmailApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductShopEmailApplication.class, args);
    }

}
