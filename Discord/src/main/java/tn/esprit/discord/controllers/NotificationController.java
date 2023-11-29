package tn.esprit.discord.controllers;

import tn.esprit.discord.entites.Notification;
import tn.esprit.discord.services.NotificationServiceimp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Notification")
@CrossOrigin(origins = "http://localhost:3000")
public class NotificationController {
   @Autowired
   private NotificationServiceimp ns ;

    @PostMapping("/add")
    public ResponseEntity<Notification> addNotification(@RequestBody Notification n) {
        try {
            Notification newn = ns.addNotification(n);
            return new ResponseEntity<>(newn, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Notification> updateNotification(@RequestBody Notification n) {
        try {
            Notification newn = ns.updateNotification(n);
            return new ResponseEntity<>(newn, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteNotification(@PathVariable("id") Long id) {
        try {
            ns.deleteNotification(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Notification> getNotificationById(@PathVariable("id") Long id) {
        try {
            Notification club = ns.getNotificationById(id);
            if (club == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(club, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/getall")
    public ResponseEntity<List<Notification>> getNotifications() {
        try {
            List<Notification> notifications = ns.getNotifications();
            if (notifications.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(notifications, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
