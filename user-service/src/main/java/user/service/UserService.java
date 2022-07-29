package user.service;

import amqp.RabbitMQMessageProducer;
import clients.notifications.NotificationClient;
import clients.notifications.dtos.NotificationRequest;
import clients.records.RecordClient;
import clients.records.dtos.RecordRequest;
import clients.records.dtos.RecordResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import user.dtos.UserRegistrationRequest;
import user.model.Person;
import user.repository.UserRepository;

@Service
@AllArgsConstructor
public class UserService {


    private final UserRepository userRepository;
    private final RecordClient recordClient;
    private final RabbitMQMessageProducer rabbitMQMessageProducer;

    public RecordResponse registerUser(UserRegistrationRequest request) {
        Person user = Person.builder()
                .fullName(request.fullName())
                .userName(request.userName())
                .mobileNo(request.mobileNo())
                .password(request.password())
                .build();

        userRepository.saveAndFlush(user);

        RecordRequest recordRequest = new RecordRequest(user.getId());

        var response = recordClient.createRecord(recordRequest);

        NotificationRequest notificationRequest = new NotificationRequest("User Created");

        rabbitMQMessageProducer.publish(
                notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key"
        );

        return response;

    }


}
