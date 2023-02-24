package com.allieduniversal.assessment.service.impl;

import com.allieduniversal.assessment.entity.Message;
import com.allieduniversal.assessment.repository.MessageRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {ChatBotServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ChatBotServiceImplTest {
    @Autowired
    private ChatBotServiceImpl chatBotServiceImpl;

    @MockBean
    private MessageRepository messageRepository;

    //Tests data retrieval
    @Test
    void testGetMsg() {
        Message message = Message.builder().id(1L).body("Not all who wander are lost").choice("YES").order(1)
                .responses(Set.of()).build();
        Optional<Message> ofResult = Optional.of(message);
        when(messageRepository.findByOrderAndChoice(anyInt(), any())).thenReturn(ofResult);
        assertSame(message, chatBotServiceImpl.getMsg(1, "YES"));
    }

    //Tests invalid message
    @Test
    void testGetMsgInvalid() {
        Message invalidMsg = Message.builder().body("I'm sorry, I didn't understand your response.").choice(null)
                .responses(Set.of()).order(0).build();
        Optional<Message> ofResult = Optional.of(invalidMsg);
        when(messageRepository.findByOrderAndChoice(anyInt(), any())).thenReturn(ofResult);
        assertSame(invalidMsg, chatBotServiceImpl.getMsg(2, "Choice"));
    }

}

