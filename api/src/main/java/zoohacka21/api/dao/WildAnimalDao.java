package zoohacka21.api.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import zoohacka21.api.entity.WildAnimal;

public interface WildAnimalDao extends MongoRepository<WildAnimal, String> {
}
