package core.basesyntax;

import core.interfaces.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private StorageDao storage = new StorageDao();
    private StringBuilder sb = new StringBuilder();

    public StorageDao getStorage() {
        return storage;
    }

    @Override
    public String getReport() {
        Map<String, Integer> map = storage.findAll();
        sb.append("fruit,quantity").append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            sb.append(entry
                    .getKey())
                    .append(',')
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }
}
