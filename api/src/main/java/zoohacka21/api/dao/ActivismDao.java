package zoohacka21.api.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import zoohacka21.api.entity.Activism;

public interface ActivismDao extends MongoRepository<Activism, String> {
}
