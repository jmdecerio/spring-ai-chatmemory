package com.jmdecerio.spring_ai_chatmemory.service;

import com.jmdecerio.spring_ai_chatmemory.model.Answer;
import com.jmdecerio.spring_ai_chatmemory.model.Question;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.stereotype.Service;

/**
 * Created by jt, Spring Framework Guru.
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class OpenAIServiceImpl implements OpenAIService {

    private final ChatClient chatClient;

    @Override
    public Answer getAnswer(Question question, String conversationId) {

        var text = chatClient.prompt()
                .user(question.question())
                .advisors(a -> a.param(ChatMemory.CONVERSATION_ID, conversationId))
                .call()
                .content();

        return new Answer(text);
    }
}
