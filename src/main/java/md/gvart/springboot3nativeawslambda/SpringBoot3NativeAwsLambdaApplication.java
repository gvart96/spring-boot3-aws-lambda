package md.gvart.springboot3nativeawslambda;

import md.gvart.springboot3nativeawslambda.domain.InputMessage;
import md.gvart.springboot3nativeawslambda.domain.OutputMessage;
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
    public Function<InputMessage, OutputMessage> uppercaseFunction() {
        return (it) -> new OutputMessage(it.message().toUpperCase());
    }
}
