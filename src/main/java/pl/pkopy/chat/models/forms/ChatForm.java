package pl.pkopy.chat.models.forms;

public class ChatForm {
    private String name;
    private String text;

    public ChatForm(){

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
}
