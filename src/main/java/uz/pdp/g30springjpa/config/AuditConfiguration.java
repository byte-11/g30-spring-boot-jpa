package uz.pdp.g30springjpa.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class AuditConfiguration {

    private final UserContext userContext;

    @Bean
    public AuditorAware<Long> auditorAware(){
        return () -> Optional.ofNullable(userContext.getId());
    }
}
