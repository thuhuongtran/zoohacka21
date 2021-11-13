package zoohacka21.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import zoohacka21.api.csvfile.CsvReader;
import zoohacka21.api.dao.RescueCenterDao;
import zoohacka21.api.entity.RescueCenter;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("rescue-center")
public class RescueCenterController {
    @Autowired
    private RescueCenterDao dao;
    @Autowired
    private CsvReader csvReader;

    @GetMapping("list")
    public List<RescueCenter> getAllRescueCenters() {
        return dao.findAll();
    }

    @PostMapping("/save-all")
    public String saveAllFromCsvFile(@RequestParam("file") MultipartFile file) {
        List<RescueCenter> rescueCenters = csvReader.loadObjectList(RescueCenter.class, file);
        dao.saveAll(rescueCenters);
        return OK.toString();
    }
}
