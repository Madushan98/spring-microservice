package notification.dtos;

public record NotificationRequest(
        String message,
        String userName
) {
}
