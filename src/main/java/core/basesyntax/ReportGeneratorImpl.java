package core.basesyntax;

import core.interfaces.ReportGenerator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        sb.append("fruit,quantity").append(System.lineSeparator());

        for (String key : keys) {
            sb.append(key)
                    .append(',')
                    .append(map.get(key))
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }
}
