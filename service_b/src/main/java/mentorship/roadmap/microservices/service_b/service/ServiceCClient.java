package mentorship.roadmap.microservices.service_b.service;

import mentorship.roadmap.microservices.service_b.entity.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceCClient {
    private final RestTemplate restTemplate;
    private final String urlServiceC;

    public ServiceCClient(RestTemplate restTemplate, @Value("${service.c.url}") String urlServiceC) {
        this.restTemplate = restTemplate;
        this.urlServiceC = urlServiceC;
    }

    public void sendToServiceC(Message message) {
        String url = urlServiceC + "/api/save";
        restTemplate.postForObject(url, message, Void.class);
    }
}
