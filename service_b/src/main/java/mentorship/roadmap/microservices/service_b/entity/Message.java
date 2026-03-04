package mentorship.roadmap.microservices.service_b.entity;


public class Message {
    private Long id;
    private String type;
    private String content;

    public Message() {
    }

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
