package zoohacka21.api.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import zoohacka21.api.entity.WildAnimal;

import java.util.List;

public interface WildAnimalDao extends MongoRepository<WildAnimal, String> {
    @Query(" { $text: { $search: ?0 } } ")
    List<WildAnimal> searchWildAnimal(String keyword);
}
