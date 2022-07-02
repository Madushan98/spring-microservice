package user.service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import user.dtos.UserRegistrationRequest;
import user.model.Person;
import user.repository.UserRepository;

@Service
@AllArgsConstructor
public class UserService {


    UserRepository userRepository ;


    public void registerUser(UserRegistrationRequest request) {
               Person user = Person.builder()
                        .fullName(request.fullName())
                        .userName(request.userName())
                        .mobileNo(request.mobileNo())
                        .password(request.password())
                        .build();

             //  Person user = new Person(request.fullName(),request.userName(),request.mobileNo(),request.password());

        userRepository.save(user);
    }


}
