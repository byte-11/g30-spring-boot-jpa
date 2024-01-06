package uz.pdp.g30springjpa;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import uz.pdp.g30springjpa.domain.Post;
import uz.pdp.g30springjpa.repo.PostRepository;

import java.net.URL;
import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class G30SpringJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(G30SpringJpaApplication.class, args);
    }

//    @Bean
    ApplicationRunner applicationRunner(
            PostRepository postRepository,
            ObjectMapper objectMapper
    ) {
        return args -> {
            List<Post> posts = objectMapper.readValue(
                    new URL("https://jsonplaceholder.typicode.com/posts"),
                    new TypeReference<List<Post>>() {}
            );
            postRepository.saveAll(posts);
        };
    }

}

/**
 * sort
 * pageable
 * method query
 * projection
 * */
