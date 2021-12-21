package kr.co.landfuture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @ComponentScan({ "kr.co.landfuture.ads.parsing" })
// @ComponentScan({ "kr.co.landfuture.ads.controllers" })
// @EntityScan("kr.co.landfuture.ads.model")
// @EnableJpaRepositories("kr.co.landfuture.ads.repository")
public class dnbnApplication {

  public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
    // SpringApplication.run(dnbnApplication.class, args);
    SpringApplication application = new SpringApplication(dnbnApplication.class);

    // dnbnApplication.selectRP(application);

    application.run(args);
  }

  // chooseing a resorce file
  public static void selectRP(SpringApplication application) {
    String u_id = System.getenv("CJS_HOST_UNIQUE_ID");
    System.out.println(u_id);
    if (u_id.contains("u2-") || u_id.contains("u6-")) {
      application.setAdditionalProfiles("u2");
    }
    System.out.println(u_id);
  }
}
