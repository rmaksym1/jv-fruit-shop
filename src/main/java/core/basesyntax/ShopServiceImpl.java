package core.basesyntax;

import core.interfaces.OperationStrategy;
import core.interfaces.ShopService;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        if (transactions != null) {
            for (FruitTransaction transaction : transactions) {
                if (transaction != null) {
                    operationStrategy.get(transaction.getOperation())
                            .apply(transaction);
                }
            }
        }
    }
}
