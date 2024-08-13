package com.mybot.whatsapp.consumer.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mybot.whatsapp.consumer.dto.MyBotMensagem;
import com.mybot.whatsapp.consumer.service.ChatProService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

@Slf4j
@Component
public class MyBotWhatsappConsumer {

    @Autowired
    private ChatProService service;

    @Autowired
    ObjectMapper objectMapper;

    @KafkaListener(topics = {"${spring.kafka.topic}"}
            , groupId = "${spring.kafka.consumer.group-id}")
    public void onMessage(@Payload String json, @Header("origem") String origem) throws JsonProcessingException {
        log.info("onMessage origem: {}", origem);
        if("cliente".equals(origem)) {
            var mensagem = objectMapper.readValue(json, MyBotMensagem.class);
            service.enviarMensagem(mensagem);
        }
    }
}
