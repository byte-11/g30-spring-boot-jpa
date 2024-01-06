package uz.pdp.g30springjpa.config.auditing;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;
import uz.pdp.g30springjpa.config.UserContext;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AuditAwareImpl implements AuditorAware<Long> {

    private final UserContext userContext;

    @Override
    public Optional<Long> getCurrentAuditor() {
        return Optional.ofNullable(userContext.getId());
    }
}
