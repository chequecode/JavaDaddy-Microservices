package mentorship.roadmap.microservices.service_a;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ServiceBClient {
    private final RestTemplate restTemplate;
    private final String urlServiceB;

    public ServiceBClient(RestTemplate restTemplate, @Value("${service.b.url}") String urlServiceB) {
        this.restTemplate = restTemplate;
        this.urlServiceB = urlServiceB;
    }

    public void sendToServiceB(Message message) {
        String fullUrl = urlServiceB + "/process";
        restTemplate.postForEntity(fullUrl, message, Void.class);
    }
}
