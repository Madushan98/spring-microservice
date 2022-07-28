package clients.notifications;

import clients.notifications.dtos.NotificationRequest;
import clients.notifications.dtos.NotificationResponse;
import clients.records.dtos.RecordRequest;
import clients.records.dtos.RecordResponse;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import javax.management.Notification;

@FeignClient("NOTIFICATION-SERVICE")
public interface NotificationClient {

    @PostMapping(path = "api/v1/notification")
    @LoadBalanced
    NotificationResponse createRecord(NotificationRequest request) ;
}
