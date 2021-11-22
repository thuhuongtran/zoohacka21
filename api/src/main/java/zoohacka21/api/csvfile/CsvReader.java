package zoohacka21.api.csvfile;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class CsvReader {

    public List<List<String>> readCsv(MultipartFile file) {
        try {
            return separateToStringItems(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    private List<List<String>> separateToStringItems(MultipartFile file) throws IOException, CsvException {
        List<List<String>> records;
        try (CSVReader reader = new CSVReader(new FileReader(toFile(file)))) {
            List<String[]> lines = reader.readAll();
            records = lines.stream().map(Arrays::asList).collect(Collectors.toList());
        }
        return records;
    }

    private File toFile(MultipartFile multipartFile) throws IOException {
        File file = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(multipartFile.getBytes());
        fos.close();
        return file;
    }
}
