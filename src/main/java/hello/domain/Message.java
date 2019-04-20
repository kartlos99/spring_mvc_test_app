package hello.domain;

import javax.persistence.*;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String body;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usr_id")
    private Usr author;

    public Message() {
    }

    public Message(String title, String body, Usr usr) {
        this.title = title;
        this.body = body;
        this.author = usr;
    }

    public String getAuthorName(){
        return author != null ? author.getUsername() : "unNown";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Usr getAuthor() {
        return author;
    }

    public void setAuthor(Usr author) {
        this.author = author;
    }
}
