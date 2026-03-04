package mentorship.roadmap.microservices.service_c.repository;

import mentorship.roadmap.microservices.service_c.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
