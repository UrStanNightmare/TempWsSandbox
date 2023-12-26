package ru.urstannightmare.wsshit.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import ru.urstannightmare.wsshit.model.ChatMessage;
import ru.urstannightmare.wsshit.model.SimpleMessage;

/**
 * @author Georgii
 */
@Slf4j
@Controller
@EnableScheduling
public class WebSocketController {
    private final SimpMessagingTemplate messagingTemplate;
    private boolean isInit = false;
    private int counter = 0;
    private String id;

    public WebSocketController(SimpMessagingTemplate simpMessagingTemplate) {
        this.messagingTemplate = simpMessagingTemplate;
    }

    @MessageMapping("/chat")
    public void processMessage(@Payload ChatMessage chatMessage) {
        log.info("Method");
        log.info(chatMessage.getSenderId());
        log.info("MESSAGE:{}{}", System.lineSeparator(), chatMessage);
        isInit = true;
        id = chatMessage.getSenderId();
        messagingTemplate.convertAndSendToUser(
                chatMessage.getSenderId(),
                "/queue/messages",
                new SimpleMessage("Pipiska"));
    }

    @Scheduled(fixedDelay = 3000L)
    private void doShit(){
        if (!isInit){
            return;
        }
        messagingTemplate.convertAndSendToUser(
                id,
                "/queue/messages",
                new SimpleMessage(String.valueOf(counter)));
        counter++;
    }
}
