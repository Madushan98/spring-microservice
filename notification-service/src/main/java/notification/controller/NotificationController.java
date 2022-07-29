package notification.controller;

import lombok.extern.slf4j.Slf4j;
import notification.dtos.NotificationRequest;
import notification.dtos.NotificationResponse;
import notification.service.NotificationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("api/v1/notification")
public class NotificationController {


    private  final  NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }


    @PostMapping
    public NotificationResponse sendNotification(@RequestBody NotificationRequest notificationRequest) {
        log.info("NotificationSent {}", notificationRequest);
        return   notificationService.sendNotification(notificationRequest);
    }

}
