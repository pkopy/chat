package pl.pkopy.chat.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.pkopy.chat.models.ChatEntity;

import java.util.List;

public interface ChatRepository extends CrudRepository<ChatEntity, Integer> {
    List<ChatEntity> findAllByOrderByIdDesc();

}
