package emlakburada.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import emlakburada.model.Message;

@Repository
public class MessageRepository {
	private static List<Message> messageList = new ArrayList<>();

	static {
		messageList.add(prepareMessage(1L, "Pazarlık olur mu?"));
		messageList.add(prepareMessage(2L, "Hala satılık mı?"));
		messageList.add(prepareMessage(3L, "Metroya koşarak 5 dk mı?"));
		messageList.add(prepareMessage(4L, "Öğrenciye ve bekara uygun mu?"));
	}

	private static Message prepareMessage(Long id, String header) {
		Message message = new Message(id, header);
		return message;
	}
	
	public List<Message> getAllMessages() {
		return messageList;
	}
	
	public Message findMessageById(Long id) {
		return messageList.stream().filter(message -> message.getId() == id).findAny().orElse(new Message());
	}
	
	public Message saveMessage(Message message) {
		messageList.add(message);
		return message;
	}
}
