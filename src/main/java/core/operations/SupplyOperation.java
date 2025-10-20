package core.operations;

import core.basesyntax.FruitTransaction;
import core.basesyntax.StorageDao;
import core.interfaces.OperationHandler;
import core.interfaces.Storage;

public class SupplyOperation implements OperationHandler {
    private final Storage storage;

    public SupplyOperation(StorageDao storage) {
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
