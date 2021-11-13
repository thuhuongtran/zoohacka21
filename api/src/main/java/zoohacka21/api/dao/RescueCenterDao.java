package zoohacka21.api.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import zoohacka21.api.entity.RescueCenter;

public interface RescueCenterDao extends MongoRepository<RescueCenter, String> {
}
