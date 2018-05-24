package pl.pkopy.chat.models.services;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service
@Scope(scopeName = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ChatService {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String generateWelcomeString() {
        if(name == null){
            throw new IllegalStateException();
        }
        return "Witaj, " + getName();
    }

}
