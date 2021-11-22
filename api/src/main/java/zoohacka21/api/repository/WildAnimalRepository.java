package zoohacka21.api.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import zoohacka21.api.csvfile.CsvReader;
import zoohacka21.api.entity.WildAnimal;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class WildAnimalRepository {
    @Autowired
    private CsvReader csvReader;

    public List<WildAnimal> readFromCsv(MultipartFile file) {
        List<WildAnimal> wildAnimals = new ArrayList<>();
        List<List<String>> records = csvReader.readCsv(file);
        records.forEach(row -> wildAnimals.add(new WildAnimal().setName(row.get(0))
                .setDescription(row.get(1))
                .setRescueCenterName(row.get(2))
                .setAlertLevel(row.get(3))
                .setImageLink(row.get(4))));
        return wildAnimals;
    }

    public boolean isValidCsvFile(MultipartFile file) {
        if (Objects.isNull(file)) return false;
        return Objects.requireNonNull(file.getOriginalFilename()).endsWith("csv");
    }

    public boolean isValidImage(MultipartFile file) {
        if (Objects.isNull(file)) return false;
        String extension = file.getOriginalFilename();
        return Objects.requireNonNull(extension).endsWith("png") || extension.endsWith("jpg");
    }
}
