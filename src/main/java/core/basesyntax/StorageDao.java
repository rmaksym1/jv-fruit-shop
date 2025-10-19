package core.basesyntax;

import core.interfaces.Storage;
import java.util.HashMap;
import java.util.Map;

public class StorageDao implements Storage {
    private static Map<String, Integer> storage = new HashMap<>();

    @Override
    public int get(String fruit, int quantity) {
        return storage.getOrDefault(fruit, 0);
    }

    @Override
    public void set(String fruit, int quantity) {
        storage.put(fruit, quantity);
    }

    @Override
    public void add(String fruit, int quantity) {
        storage.put(fruit, get(fruit, 0) + quantity);
    }

    @Override
    public void subtract(String fruit, int quantity) {
        storage.put(fruit, get(fruit, 0) - quantity);
    }

    @Override
    public Map<String, Integer> findAll() {
        return new HashMap<>(storage);
    }
}
