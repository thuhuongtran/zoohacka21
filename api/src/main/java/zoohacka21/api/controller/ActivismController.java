package zoohacka21.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import zoohacka21.api.csvfile.CsvReader;
import zoohacka21.api.dao.ActivismDao;
import zoohacka21.api.entity.Activism;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("activism")
public class ActivismController {
    @Autowired
    private ActivismDao dao;

    @GetMapping("list")
    public List<Activism> getAllActivism() {
        return dao.findAll();
    }

    @PostMapping("/save-all")
    public String saveAllFromCsvFile(@RequestParam("file") MultipartFile file) {
//        List<Activism> activisms = csvReader.loadObjectList(Activism.class, file);
//        dao.saveAll(activisms);
        return OK.toString();
    }
}
