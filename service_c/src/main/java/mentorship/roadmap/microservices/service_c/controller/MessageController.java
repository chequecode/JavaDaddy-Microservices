package mentorship.roadmap.microservices.service_c.controller;

import mentorship.roadmap.microservices.service_c.entity.Message;
import mentorship.roadmap.microservices.service_c.repository.MessageRepository;
import mentorship.roadmap.microservices.service_c.service.KafkaProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class MessageController {
    private final KafkaProducerService kafkaProducerService;
    private final MessageRepository messageRepository;

    public MessageController(KafkaProducerService kafkaProducerService, MessageRepository messageRepository) {
        this.kafkaProducerService = kafkaProducerService;
        this.messageRepository = messageRepository;
    }

    @PostMapping("/save")
    public ResponseEntity<Void> saveAndPublishToTopic(@RequestBody Message message) {
        messageRepository.save(message);
        kafkaProducerService.sendToOutTopic(message);
        return ResponseEntity.ok().build();
    }
}
