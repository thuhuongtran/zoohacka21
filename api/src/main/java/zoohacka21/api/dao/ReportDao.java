package zoohacka21.api.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import zoohacka21.api.entity.Report;

public interface ReportDao extends MongoRepository<Report, String> {
}
