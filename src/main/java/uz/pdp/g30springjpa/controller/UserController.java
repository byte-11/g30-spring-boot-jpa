package uz.pdp.g30springjpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.g30springjpa.domain.User;
import uz.pdp.g30springjpa.dto.UserRegisterDto;
import uz.pdp.g30springjpa.dto.projection.UserDto;
import uz.pdp.g30springjpa.dto.projection.UserDtoInterface;
import uz.pdp.g30springjpa.service.UserService;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public User registerUser(@RequestBody UserRegisterDto registerDto){
        return userService.register(registerDto);
    }

    @GetMapping
    public UserDtoInterface getByUsername(@RequestParam String username){
//        return userService.getByUsername(username);
        return userService.getByUsernameWithQuery(username);
    }

    @GetMapping("/e")
    public UserDto getByEmail(@RequestParam String email){
//        return userService.getByEmail(email);
        return userService.getByEmailWithQuery(email);
    }
}
