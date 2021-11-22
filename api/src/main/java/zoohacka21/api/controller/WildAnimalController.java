package zoohacka21.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import zoohacka21.api.dao.WildAnimalDao;
import zoohacka21.api.entity.WildAnimal;
import zoohacka21.api.repository.WildAnimalRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("wild-animal")
public class WildAnimalController {
    @Autowired
    private WildAnimalDao dao;
    @Autowired
    private WildAnimalRepository repository;

    @GetMapping("list")
    @CrossOrigin
    public List<WildAnimal> getAllWildAnimals() {
        return dao.findAll();
    }

    @PostMapping("save-all")
    public List<WildAnimal> saveAllFromCsvFile(@RequestParam("file") MultipartFile file) {
        if (repository.isValidCsvFile(file)) {
            List<WildAnimal> wildAnimals = repository.readFromCsv(file);
            dao.saveAll(wildAnimals);
            return wildAnimals;
        }
        return new ArrayList<>();
    }

    @GetMapping("search-by-text")
    @CrossOrigin
    public WildAnimal searchWildAnimal(@RequestParam("keyword") String keyword) {
        if (Objects.nonNull(keyword)) {
            List<WildAnimal> wildAnimals = dao.searchWildAnimal(keyword);
            if (wildAnimals.size() > 0) return wildAnimals.get(0);
        }
        return new WildAnimal();
    }
}
