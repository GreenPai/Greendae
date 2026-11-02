package kr.co.greendae;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.GetMapping;

@EnableJpaAuditing
@SpringBootApplication
public class GreendaeApplication {

    public static void main(String[] args) {
        SpringApplication.run(GreendaeApplication.class, args);
    }

}
