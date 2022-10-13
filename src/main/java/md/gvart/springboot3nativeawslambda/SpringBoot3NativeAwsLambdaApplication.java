package md.gvart.springboot3nativeawslambda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class SpringBoot3NativeAwsLambdaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot3NativeAwsLambdaApplication.class, args);
    }


    @Bean
    public Function<String, String> uppercaseFunction() {
        return String::toUpperCase;
    }
}
