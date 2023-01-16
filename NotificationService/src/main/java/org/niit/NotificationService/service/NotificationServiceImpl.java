package org.niit.NotificationService.service;


import org.niit.NotificationService.configuration.ProductDTO;
import org.niit.NotificationService.domain.Notification;
import org.niit.NotificationService.repository.NotificationRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements INotificationService{
    @Autowired
    private NotificationRepository notificationRepository;


    @Override
    public Notification getAllNotification(String email) {
        return notificationRepository.findById(email).get() ;
    }

    @RabbitListener(queues = "UserProductQueue")
    @Override
    public void saveNotification(ProductDTO productDTO) {

        //object of notification
        Notification notification=new Notification();
        //fetch email from DTO object
        String email=productDTO.getJsonObject().get("email").toString();
        if(notificationRepository.findById(email).isEmpty()){
            notification.setEmail(email);
        }
        notification.setNotificationMessage("List of no watched movies");
        notification.setJsonObject(productDTO.getJsonObject());
        notificationRepository.save(notification);
    }
}
