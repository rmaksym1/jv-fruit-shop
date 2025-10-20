package core.operations;

import core.basesyntax.FruitTransaction;
import core.basesyntax.StorageDao;
import core.interfaces.OperationHandler;

public class BalanceOperation implements OperationHandler {
    private final StorageDao storage;

    public BalanceOperation(StorageDao storage) {
        this.storage = storage;
    }

    @Override
    public void apply(FruitTransaction tx) {
        if (tx != null && tx.getQuantity() >= 0) {
            storage.set(tx.getFruit(), tx.getQuantity());
        }
    }
}
