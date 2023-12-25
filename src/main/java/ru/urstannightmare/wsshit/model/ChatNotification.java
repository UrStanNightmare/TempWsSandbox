package ru.urstannightmare.wsshit.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChatNotification {
    private String id;
    private String senderId;
    private String senderName;
}
