package core.interfaces;

import core.basesyntax.FruitTransaction;

import java.util.Map;

public interface Storage {
    public int get(String fruit, int quantity);
    public void set(String fruit, int quantity);
    public void add(String fruit, int quantity);
    public void substract(String fruit, int quantity);
    public Map<String, Integer> findAll();
}
