package pl.pkopy.chat.models;

import pl.pkopy.chat.models.forms.ChatForm;

import javax.persistence.*;

@Entity
@Table(name = "chat")
public class ChatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String text;

    @Column(name = "time_stamp")
    private String time;

    public ChatEntity() {

    }

    public ChatEntity(ChatForm chatForm){
        setName(chatForm.getName());
        setText(chatForm.getText());
        setTime(chatForm.getTime());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
