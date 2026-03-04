package mentorship.roadmap.microservices.service_a;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerService {
    private final MessageRepository messageRepository;
    private final ServiceBClient serviceBClient;

    public KafkaConsumerService(MessageRepository messageRepository, ServiceBClient serviceBClient) {
        this.messageRepository = messageRepository;
        this.serviceBClient = serviceBClient;
    }

    @KafkaListener(topics = "in", groupId = "service-a")
    public void consume(Message message) {
        System.out.println("Получено сообщение: " + message);
        messageRepository.save(message);
        serviceBClient.sendToServiceB(message);
    }

}
