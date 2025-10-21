package operations;

import service.impl.FruitTransaction;
import service.impl.StorageDao;
import interfaces.OperationHandler;
import interfaces.Storage;

public class BalanceOperation implements OperationHandler {
    private final Storage storage;

    public BalanceOperation(Storage storage) {
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
