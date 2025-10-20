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
                    if (transaction.getOperation() != null) {
                        operationStrategy.get(transaction.getOperation())
                                .apply(transaction);
                    } else {
                        throw new IllegalArgumentException(
                                "Operation inside transaction cannot be null!"
                        );
                    }
                } else {
                    throw new IllegalArgumentException("Transaction is null!");
                }
            }
        } else {
            throw new IllegalArgumentException("Transactions can't be null!");
        }
    }
}
