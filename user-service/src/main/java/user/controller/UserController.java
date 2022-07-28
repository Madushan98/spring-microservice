package user.controller;


import clients.records.dtos.RecordResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import user.dtos.UserRegistrationRequest;
import user.service.UserService;

@Slf4j
@RestController
@RequestMapping("api/v1/user")
public class UserController {


    private final UserService userService ;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public RecordResponse registerUser(@RequestBody UserRegistrationRequest userRegistrationRequest){
        log.info("new User Registration {}", userRegistrationRequest);
        return userService.registerUser(userRegistrationRequest);
    }


}
