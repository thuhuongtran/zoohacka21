package zoohacka21.api.csvfile;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Component
public class CsvReader {
    public <T> List<T> loadObjectList(Class<T> type, MultipartFile multipartFile) {
        try {
            CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
            CsvMapper mapper = new CsvMapper();
            File file = toFile(multipartFile);
            MappingIterator<T> readValues =
                    mapper.reader(type).with(bootstrapSchema).readValues(file);
            return readValues.readAll();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    private File toFile(MultipartFile multipartFile) throws IOException {
        File file = new File("src/main/resources/temp.csv");
        multipartFile.transferTo(file);
        return file;
    }
}
