package zoohacka21.api.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import zoohacka21.api.csvfile.CsvReader;
import zoohacka21.api.entity.RescueCenter;

import java.util.ArrayList;
import java.util.List;

@Component
public class RescueCentersRepository {
    @Autowired
    private CsvReader csvReader;

    public List<RescueCenter> readFromCsv(MultipartFile file) {
        List<RescueCenter> rescueCenters = new ArrayList<>();
        List<List<String>> records = csvReader.readCsv(file);
        records.forEach(row -> rescueCenters.add(new RescueCenter()
                .setName(row.get(0))
                .setDescription(row.get(1))
                .setOrganizationUrl(row.get(2))
                .setLocation(row.get(3))
                .setPhone(row.get(4))
                .setImageLink(row.get(5))));
        return rescueCenters;
    }
}
