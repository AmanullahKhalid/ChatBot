package com.allieduniversal.assessment.service.impl;

import com.allieduniversal.assessment.entity.Message;
import com.allieduniversal.assessment.repository.MessageRepository;
import com.allieduniversal.assessment.service.ChatBotService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class ChatBotServiceImpl implements ChatBotService {

    public static final String INVALID_MSG = "I'm sorry, I didn't understand your response. ";
    private final MessageRepository messageRepository;

    @Override
    public Message getMsg(int order, String choice) {
        return messageRepository.findByOrderAndChoice(order, choice)
                .orElse(Message.builder().body(INVALID_MSG).choice(null).responses(Set.of())
                        .order(--order).build());
    }
}
