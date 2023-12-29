package ru.urstannightmare.wsshit.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ChatMessage {
    private String id;
    private String chatId;
    private String senderId;
//    private String recipientId;
//    private String senderName;
//    private String recipientName;
    private String content;
//    private Date timestamp;
}
