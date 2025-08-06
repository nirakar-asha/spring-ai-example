package com.example.springai.awsbedrock.chat.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public String chat(@RequestParam(defaultValue = "What is the capital of India?") String message) {
        return this.chatClient.prompt()
                .user(message)
                .call()
                .content();
    }
}
