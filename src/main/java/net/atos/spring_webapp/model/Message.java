package net.atos.spring_webapp.model;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Long messageId;

    private String title;
    private String message;
    private LocalDateTime addedDate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User receiver;
}
