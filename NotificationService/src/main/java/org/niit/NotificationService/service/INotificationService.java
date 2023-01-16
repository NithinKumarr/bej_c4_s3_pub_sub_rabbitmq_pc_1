package org.niit.NotificationService.service;


import org.niit.NotificationService.configuration.ProductDTO;
import org.niit.NotificationService.domain.Notification;

public interface INotificationService {
    public Notification getAllNotification(String email);
    public void saveNotification(ProductDTO productDTO);
}
