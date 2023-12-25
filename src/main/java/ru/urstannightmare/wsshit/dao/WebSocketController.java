package ru.urstannightmare.wsshit.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import ru.urstannightmare.wsshit.model.ChatMessage;
import ru.urstannightmare.wsshit.model.SimpleMessage;

/**
 * @author Georgii
 */
@Slf4j
@Controller
public class WebSocketController{
    private final SimpMessagingTemplate messagingTemplate;

    public WebSocketController(SimpMessagingTemplate simpMessagingTemplate) {
        this.messagingTemplate = simpMessagingTemplate;
    }

    @MessageMapping("/chat")
    public void processMessage(@Payload ChatMessage chatMessage) {
        log.info("Method");
        log.info(chatMessage.getSenderId());
        messagingTemplate.convertAndSendToUser(
                chatMessage.getSenderId(),
                "/queue/messages",
                new SimpleMessage("Pipiska"));
    }
}
