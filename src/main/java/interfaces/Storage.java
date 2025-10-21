package interfaces;

import java.util.Map;

public interface Storage {

    public int get(String fruit);

    public void set(String fruit, int quantity);

    public void add(String fruit, int quantity);

    public void subtract(String fruit, int quantity);

    public Map<String, Integer> findAll();
}
