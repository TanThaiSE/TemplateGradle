package training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;

/**
 * Created by tsukasa on 2014/11/08.
 */
@SpringBootApplication(exclude = JacksonAutoConfiguration.class)
public class MemberApplication {

  public static void main(String[] args) {
    SpringApplication.run(MemberApplication.class, args);
  }
}
