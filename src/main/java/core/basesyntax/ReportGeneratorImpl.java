package core.basesyntax;

import core.interfaces.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private final StorageDao storage;

    public ReportGeneratorImpl(StorageDao storage) {
        this.storage = storage;
    }

    @Override
    public String getReport() {
        StringBuilder sb = new StringBuilder();
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
