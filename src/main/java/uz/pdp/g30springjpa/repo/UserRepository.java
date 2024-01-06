package uz.pdp.g30springjpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.pdp.g30springjpa.domain.User;
import uz.pdp.g30springjpa.dto.projection.UserDto;
import uz.pdp.g30springjpa.dto.projection.UserDtoInterface;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<UserDtoInterface> findByUsername(String username);

    @Query("SELECT u FROM User u")
    Optional<UserDtoInterface> findByUsernameWithQuery(String username);

    Optional<UserDto> findByEmail(String email);

    @Query("""
    SELECT new uz.pdp.g30springjpa.dto.projection.UserDto(u.id, u.username, u.email) 
    FROM User u where u.email = :email
    """)
    Optional<UserDto> findByEmailWithQuery(String email);
}
