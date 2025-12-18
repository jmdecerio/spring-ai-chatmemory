package com.jmdecerio.spring_ai_chatmemory.controllers;

import com.jmdecerio.spring_ai_chatmemory.model.Answer;
import com.jmdecerio.spring_ai_chatmemory.model.Question;
import com.jmdecerio.spring_ai_chatmemory.service.OpenAIService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jt, Spring Framework Guru.
 */
@RequiredArgsConstructor
@RestController
public class QuestionController {

    private final OpenAIService openAIService;

    @PostMapping("/ask")
    public Answer askQuestion(@RequestHeader(name="CONVERSATION_ID", defaultValue = "default") String conversationId, @RequestBody Question question) {
        return openAIService.getAnswer(question, conversationId);
    }

}
