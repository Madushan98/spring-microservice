package user.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import user.dtos.UserRegistrationRequest;
import user.service.UserService;

@Slf4j
@RestController
@RequestMapping("api/vi/user")
public class UserController {


    UserService userService ;

    @PostMapping
    public void registerUser(@RequestBody UserRegistrationRequest userRegistrationRequest){
        log.info("new User Registration {}", userRegistrationRequest);
        userService.registerUser(userRegistrationRequest);

    }


}
