package ru.urstannightmare.wsshit.service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@EnableScheduling
public class BullshitSender {


//    @Scheduled(fixedDelay = 5000)
    @SneakyThrows
    public void sendShit() {

    }
}
