package com.jmdecerio.spring_ai_chatmemory.service;

import com.jmdecerio.spring_ai_chatmemory.model.Answer;
import com.jmdecerio.spring_ai_chatmemory.model.Question;

/**
 * Created by jt, Spring Framework Guru.
 */
public interface OpenAIService {

    Answer getAnswer(Question question, String conversationId);
}
