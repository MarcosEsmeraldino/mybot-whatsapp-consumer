package com.mybot.whatsapp.consumer.dto;

public record MyBotMensagem(
     String mensagem,
     MyBotCliente cliente,
     MyBotHost host,
     MyBotTipoEnum tipo
) { }