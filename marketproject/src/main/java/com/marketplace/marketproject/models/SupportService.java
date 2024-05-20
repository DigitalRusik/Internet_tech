package com.marketplace.marketproject.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupportService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getAllMessages(String receiver, String writer) {
        if (receiver != null)
            return questionRepository.findByReceiverOrWriter(receiver, writer);
        return questionRepository.findAll();
    }

    public void addMessage(String question, String writer, String receiver) {
        Question newQuestion = new Question();
        newQuestion.setContent(question);
        newQuestion.setWriter(writer);
        newQuestion.setReceiver(receiver);
        questionRepository.save(newQuestion);
    }
}
