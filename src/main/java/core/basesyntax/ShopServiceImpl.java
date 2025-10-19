package core.basesyntax;

import core.interfaces.OperationStrategy;
import core.interfaces.ShopService;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    OperationStrategy operationStrategy;
    StorageDao storage;
    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
        this.storage = new StorageDao();
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            operationStrategy.get(transaction.getOperation())
                    .apply(transaction, storage);
        }
    }
}
