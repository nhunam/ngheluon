package saola.com.ngheluon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class NgheluonApplication {

  public static void main(String[] args) {
    SpringApplication.run(NgheluonApplication.class, args);
  }
  
  @Bean
  public Docket productApi() {
     return new Docket(DocumentationType.SWAGGER_2).select()
        .apis(RequestHandlerSelectors.basePackage("saola.com.ngheluon.controller")).build();
  }

}
