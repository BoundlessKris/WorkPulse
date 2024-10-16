package com.service.impl;

import com.dao.interfaces.MessageDao;
import com.model.Message;
import com.service.interfaces.MessageService;
import java.util.List;

public class MessageServiceImpl implements MessageService {
    private MessageDao messageDao;

    public MessageServiceImpl(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    @Override
    public Message sendMessage(Message message) throws Exception {
        validateMessage(message);
        return messageDao.create(message);
    }

    @Override
    public Message getMessageById(int id) throws Exception {
        Message message = messageDao.findById(id);
        if (message == null) {
            throw new Exception("Message not found with id: " + id);
        }
        return message;
    }

    @Override
    public List<Message> getMessagesBySenderId(int senderId) throws Exception {
        return messageDao.findBySenderId(senderId);
    }

    @Override
    public List<Message> getMessagesByReceiverId(int receiverId) throws Exception {
        return messageDao.findByReceiverId(receiverId);
    }

    @Override
    public List<Message> getConversation(int user1Id, int user2Id) throws Exception {
        return messageDao.findConversation(user1Id, user2Id);
    }

    @Override
    public Message updateMessage(Message message) throws Exception {
        validateMessage(message);
        Message existingMessage = getMessageById(message.getMessageId());
        if (existingMessage == null) {
            throw new Exception("Message not found for update with id: " + message.getMessageId());
        }
        return messageDao.update(message);
    }

    @Override
    public void deleteMessage(int id) throws Exception {
        Message message = getMessageById(id);
        if (message == null) {
            throw new Exception("Message not found for deletion with id: " + id);
        }
        messageDao.delete(id);
    }

    @Override
    public void markMessageAsRead(int messageId) throws Exception {
        messageDao.markAsRead(messageId);
    }

    @Override
    public int countUnreadMessages(int userId) throws Exception {
        return messageDao.countUnreadMessages(userId);
    }

    @Override
    public List<Message> getRecentMessages(int userId, int limit) throws Exception {
        return messageDao.findRecentMessages(userId, limit);
    }

    @Override
    public List<Message> searchMessages(int userId, String keywords) throws Exception {
        return messageDao.searchMessages(userId, keywords);
    }

    @Override
    public List<Integer> getRecentConversationPartners(int userId, int limit) throws Exception {
        // This might require a more complex query or multiple queries
        throw new UnsupportedOperationException("This operation is not yet implemented");
    }

    private void validateMessage(Message message) throws IllegalArgumentException {
        if (message == null) {
            throw new IllegalArgumentException("Message cannot be null");
        }
        if (message.getSenderId() <= 0) {
            throw new IllegalArgumentException("Invalid sender ID");
        }
        if (message.getReceiverId() <= 0) {
            throw new IllegalArgumentException("Invalid receiver ID");
        }
        if (message.getContent() == null || message.getContent().trim().isEmpty()) {
            throw new IllegalArgumentException("Message content cannot be empty");
        }
    }
}
