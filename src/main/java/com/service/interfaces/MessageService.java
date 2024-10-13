package com.service.interfaces;

import com.model.Message;
import java.util.List;

public interface MessageService {
    Message sendMessage(Message message) throws Exception;
    Message getMessageById(int id) throws Exception;
    List<Message> getMessagesBySenderId(int senderId) throws Exception;
    List<Message> getMessagesByReceiverId(int receiverId) throws Exception;
    List<Message> getConversation(int user1Id, int user2Id) throws Exception;
    Message updateMessage(Message message) throws Exception;
    void deleteMessage(int id) throws Exception;
    void markMessageAsRead(int messageId) throws Exception;
    int countUnreadMessages(int userId) throws Exception;
    List<Message> getRecentMessages(int userId, int limit) throws Exception;
    List<Message> searchMessages(int userId, String keywords) throws Exception;
    List<Integer> getRecentConversationPartners(int userId, int limit) throws Exception;
}
