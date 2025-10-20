package core.operations;

import core.basesyntax.FruitTransaction;
import core.basesyntax.StorageDao;
import core.interfaces.OperationHandler;
import core.interfaces.Storage;

public class BalanceOperation implements OperationHandler {
    private final Storage storage;

    public BalanceOperation(StorageDao storage) {
        this.storage = storage;
    }

    @Override
    public void apply(FruitTransaction tx) {
        if (tx == null) {
            throw new IllegalArgumentException("Transaction cannot be null");
        }
        if (tx.getQuantity() < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative: " + tx.getQuantity());
        }
        storage.set(tx.getFruit(), tx.getQuantity());
    }
}
