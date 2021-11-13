package zoohacka21.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import zoohacka21.api.csvfile.CsvReader;
import zoohacka21.api.dao.WildAnimalDao;
import zoohacka21.api.entity.WildAnimal;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("wild-animal")
public class WildAnimalController {
    @Autowired
    private WildAnimalDao dao;
    @Autowired
    CsvReader csvReader;

    @GetMapping("list")
    public List<WildAnimal> getAllWildAnimals() {
        return dao.findAll();
    }

    @PostMapping("/save-all")
    public String saveAllFromCsvFile(@RequestParam("file") MultipartFile file) {
        List<WildAnimal> wildAnimals = csvReader.loadObjectList(WildAnimal.class, file);
        dao.saveAll(wildAnimals);
        return OK.toString();
    }
}
