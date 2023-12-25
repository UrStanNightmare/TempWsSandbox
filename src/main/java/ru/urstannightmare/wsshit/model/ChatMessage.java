package ru.urstannightmare.wsshit.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChatMessage {
    @Id
    private String id;
    private String chatId;
    private String senderId;
//    private String recipientId;
//    private String senderName;
//    private String recipientName;
    private String content;
//    private Date timestamp;
}
