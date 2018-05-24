package pl.pkopy.chat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.pkopy.chat.models.ChatEntity;
import pl.pkopy.chat.models.forms.ChatForm;
import pl.pkopy.chat.models.repositories.ChatRepository;
import pl.pkopy.chat.models.services.ChatService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {



    @Autowired
    ChatRepository chatRepository;
    @Autowired
    ChatService chatService;

    @GetMapping("/")

    public String chat(Model model) {
        model.addAttribute("chatForm", new ChatForm());
        return "chat";
    }

    @PostMapping("/")

    public String index(@ModelAttribute ChatForm chatForm, Model model){
        ChatEntity chatEntity = new ChatEntity(chatForm);

        model.addAttribute("name", chatEntity.getName());
        chatService.setName(chatEntity.getName());

        return "conversation";
    }

    @GetMapping("/conversation")

    public String conversation(Model model) {
        model.addAttribute("chatForm", new ChatForm());
        return "conversation";
    }

    @PostMapping("/conversation")

    public String conversationPost(@ModelAttribute ChatForm chatForm, Model model){
        ChatEntity chatEntity = new ChatEntity(chatForm);
        chatEntity.setName(chatService.getName());
        chatRepository.save(chatEntity);
        List<ChatEntity> chatEntities = new ArrayList<>();
        chatEntities.addAll(chatRepository.findAllByOrderByIdDesc());




        model.addAttribute("chatForm", new ChatForm());
        model.addAttribute("allChats", chatEntities);

        model.addAttribute("text", chatEntity.getText());
        model.addAttribute("name",chatService.getName());

        return "conversation";
    }
}
