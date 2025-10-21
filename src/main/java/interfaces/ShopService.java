package interfaces;

import service.impl.FruitTransaction;
import java.util.List;

public interface ShopService {
    public void process(List<FruitTransaction> transactions);
}
