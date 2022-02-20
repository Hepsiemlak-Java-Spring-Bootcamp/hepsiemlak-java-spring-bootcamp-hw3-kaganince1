package emlakburada.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlakburada.dto.MessageRequest;
import emlakburada.dto.response.MessageResponse;
import emlakburada.model.Message;
import emlakburada.repository.MessageRepository;

@Service
public class MessageService {
	
	@Autowired
	private MessageRepository messageRepository;
	
	private static Long messageId = 4L;
	
	public List<MessageResponse> getAllMessages() {
		List<MessageResponse> messageResponseList = new ArrayList<>();
		for(Message message : messageRepository.getAllMessages()) {
			messageResponseList.add(convertToMessageResponse(message));
		}
		return messageResponseList;
	}
	
	public MessageResponse getMessageById(Long id) {
		Message message = messageRepository.findMessageById(id);
		return convertToMessageResponse(message);
	}
	
	public MessageResponse saveMessage(MessageRequest messageRequest) {
		Message savedMessage = messageRepository.saveMessage(convertToAdvert(messageRequest));
		return convertToMessageResponse(savedMessage);
	}

	private Message convertToAdvert(MessageRequest messageRequest) {
		Message message = new Message();
		messageId++;
		message.setId(messageId);
		message.setBaslik(messageRequest.getBaslik());
		return message;
	}

	private MessageResponse convertToMessageResponse(Message message) {
		MessageResponse messageResponse = new MessageResponse();
		messageResponse.setId(message.getId());
		messageResponse.setBaslik(message.getBaslik());
		return messageResponse;
	}
}
