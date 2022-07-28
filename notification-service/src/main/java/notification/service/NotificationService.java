package notification.service;


import lombok.AllArgsConstructor;
import notification.dtos.NotificationRequest;
import notification.dtos.NotificationResponse;
import notification.models.Notification;
import notification.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {


    private final NotificationRepository repository;

    public NotificationResponse createRecord(NotificationRequest request) {
        Notification notification = Notification.builder()
                .message(request.message())
                .sender("admin")
                .sendTo(request.userName())
                .sentAt(LocalDateTime.now())
                .build();
        repository.saveAndFlush(notification);

        return new NotificationResponse("Welcome" + request.userName());
    }
}
