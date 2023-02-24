package com.allieduniversal.assessment.service;

import com.allieduniversal.assessment.entity.Message;

public interface ChatBotService {
    Message getMsg(int order, String choice);
}
