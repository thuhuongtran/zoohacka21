package zoohacka21.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import zoohacka21.api.csvfile.CsvReader;
import zoohacka21.api.dao.ReportDao;
import zoohacka21.api.entity.Report;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("report")
public class ReportController {
    @Autowired
    private ReportDao dao;
    @GetMapping("list")
    public List<Report> getAllReport() {
        return dao.findAll();
    }

    @PostMapping("/save-all")
    public String saveAllFromCsvFile(@RequestParam("file") MultipartFile file) {
//        List<Report> reports = csvReader.loadObjectList(Report.class, file);
//        dao.saveAll(reports);
        return OK.toString();
    }
}
