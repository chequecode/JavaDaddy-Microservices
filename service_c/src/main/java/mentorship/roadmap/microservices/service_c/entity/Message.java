package mentorship.roadmap.microservices.service_c.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Message {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "type")
    private String type;
    @Column(name = "content")
    private String content;

    public Message(Long id, String type, String content) {
        this.id = id;
        this.type = type;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
