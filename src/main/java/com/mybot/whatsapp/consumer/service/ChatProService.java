package com.mybot.whatsapp.consumer.service;

import com.mybot.whatsapp.consumer.dto.MyBotMensagem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ChatProService {

    public void enviarMensagem(MyBotMensagem mensagem) {
        log.info("Enviar mensagem {}", mensagem);
    }
}
