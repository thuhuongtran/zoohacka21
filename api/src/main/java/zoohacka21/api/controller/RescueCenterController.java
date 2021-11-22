package zoohacka21.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import zoohacka21.api.dao.RescueCenterDao;
import zoohacka21.api.entity.RescueCenter;
import zoohacka21.api.repository.RescueCentersRepository;

import java.util.List;

@RestController
@RequestMapping("rescue-center")
public class RescueCenterController {
    @Autowired
    private RescueCenterDao dao;
    @Autowired
    private RescueCentersRepository repository;

    @GetMapping("list")
    @CrossOrigin
    public List<RescueCenter> getAllRescueCenters() {
        return dao.findAll();
    }

    @PostMapping("save-all")
    public List<RescueCenter> saveAllFromCsvFile(@RequestParam("file") MultipartFile file) {
        List<RescueCenter> rescueCenters = repository.readFromCsv(file);
        dao.saveAll(rescueCenters);
        return rescueCenters;
    }
}
