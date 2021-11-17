package dan.dirty.aoplog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class AopLogApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopLogApplication.class, args);
    }

}
