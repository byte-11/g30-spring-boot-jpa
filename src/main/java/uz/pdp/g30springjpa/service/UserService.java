package uz.pdp.g30springjpa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.g30springjpa.domain.User;
import uz.pdp.g30springjpa.dto.UserRegisterDto;
import uz.pdp.g30springjpa.dto.projection.UserDto;
import uz.pdp.g30springjpa.dto.projection.UserDtoInterface;
import uz.pdp.g30springjpa.repo.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public User register(UserRegisterDto registerDto){
        return  userRepository.save(new User(registerDto.getUsername(),
                registerDto.getEmail(),
                registerDto.getPassword()));
    }

    public UserDtoInterface getByUsername(String username){
        return userRepository.findByUsername(username).get();
    }

    public UserDtoInterface getByUsernameWithQuery(String username){
        return userRepository.findByUsernameWithQuery(username).get();
    }

    public UserDto getByEmail(String email){
        return userRepository.findByEmail(email).get();
    }

    public UserDto getByEmailWithQuery(String email){
        return userRepository.findByEmailWithQuery(email).get();
    }
}
