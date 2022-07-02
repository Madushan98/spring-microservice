package user.dtos;

public record UserRegistrationRequest(
        String userName,
        String mobileNo,
        String fullName,
        String password
) {



}
