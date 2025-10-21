package service.impl;

import interfaces.Storage;
import java.util.HashMap;
import java.util.Map;

public class StorageDao implements Storage {
    private final Map<String, Integer> storage = new HashMap<>();

    @Override
    public int get(String fruit) {
        return storage.getOrDefault(fruit, 0);
    }

    @Override
    public void set(String fruit, int quantity) {
        storage.put(fruit, quantity);
    }

    @Override
    public void add(String fruit, int quantity) {
        storage.put(fruit, get(fruit) + quantity);
    }

    @Override
    public void subtract(String fruit, int quantity) {
        storage.put(fruit, get(fruit) - quantity);
    }

    @Override
    public Map<String, Integer> findAll() {
        return new HashMap<>(storage);
    }
}
