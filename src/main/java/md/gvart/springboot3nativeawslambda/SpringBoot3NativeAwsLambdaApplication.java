package md.gvart.springboot3nativeawslambda;

import md.gvart.springboot3nativeawslambda.domain.ApiResponse;
import md.gvart.springboot3nativeawslambda.domain.InputMessage;
import md.gvart.springboot3nativeawslambda.domain.OutputMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootApplication
public class SpringBoot3NativeAwsLambdaApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringBoot3NativeAwsLambdaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot3NativeAwsLambdaApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder()
                .build();
    }

    @Bean
    public Supplier<OutputMessage> randomJoke(RestTemplate restTemplate) {
        return () -> {
            var response = restTemplate.getForObject(
                    "https://some-random-api.ml/joke",
                    ApiResponse.class
            );
            return new OutputMessage(response.joke());
        };
    }

    @Bean
    public Function<InputMessage, OutputMessage> lowercaseFunction() {
        return (it) -> new OutputMessage(it.message().toLowerCase());
    }


    @Bean
    public Consumer<InputMessage> consumerFunction() {
        return (it) -> {
            log.info("Consumed message in function:{}", it.message());
        };
    }

}
