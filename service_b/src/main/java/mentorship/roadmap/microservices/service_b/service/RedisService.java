package mentorship.roadmap.microservices.service_b.service;

import mentorship.roadmap.microservices.service_b.entity.Message;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService {
    private final RedisTemplate<String, Message> redisTemplate;

    public RedisService(RedisTemplate<String, Message> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void saveIfImportant(Message message) {
        if ("important".equalsIgnoreCase(message.getType())) {
            String key = "important: " + message.getId();
            redisTemplate.opsForValue().set(key, message, 5, TimeUnit.MINUTES);
        }
    }
}
