package mentorship.roadmap.microservices.service_b.controller;

import mentorship.roadmap.microservices.service_b.entity.Message;
import mentorship.roadmap.microservices.service_b.service.RedisService;
import mentorship.roadmap.microservices.service_b.service.ServiceCClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class MessageController {
    private final RedisService redisService;
    private final ServiceCClient serviceCClient;

    public MessageController(RedisService redisService, ServiceCClient serviceCClient) {
        this.redisService = redisService;
        this.serviceCClient = serviceCClient;
    }

    @PostMapping("/process")
    public ResponseEntity<Void> processMessage(@RequestBody Message message) {
        redisService.saveIfImportant(message);
        serviceCClient.sendToServiceC(message);
        return ResponseEntity.ok().build();
    }
}
