package core.interfaces;

import core.basesyntax.FruitTransaction;
import java.util.List;

public interface ShopService {
    public void process(List<FruitTransaction> transactions);
}
