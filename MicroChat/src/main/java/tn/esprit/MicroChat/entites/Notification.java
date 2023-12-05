package tn.esprit.MicroChat.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idNotification;
    private String title;
    private String description;
    private Date creationDate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
