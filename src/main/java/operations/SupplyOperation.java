package operations;

import service.impl.FruitTransaction;
import service.impl.StorageDao;
import interfaces.OperationHandler;
import interfaces.Storage;

public class SupplyOperation implements OperationHandler {
    private final Storage storage;

    public SupplyOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void apply(FruitTransaction tx) {
        if (tx != null) {
            if (tx.getQuantity() < 0) {
                throw new IllegalArgumentException("Quantity cannot be negative: "
                        + tx.getQuantity());
            }
            storage.add(tx.getFruit(), tx.getQuantity());
        } else {
            throw new IllegalArgumentException("Transaction cannot be null");
        }
    }
}
