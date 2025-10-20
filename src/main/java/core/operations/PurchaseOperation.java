package core.operations;

import core.basesyntax.FruitTransaction;
import core.basesyntax.StorageDao;
import core.interfaces.OperationHandler;
import core.interfaces.Storage;

public class PurchaseOperation implements OperationHandler {
    private final Storage storage;

    public PurchaseOperation(StorageDao storage) {
        this.storage = storage;
    }

    @Override
    public void apply(FruitTransaction tx) {
        if (tx != null) {
            if (tx.getQuantity() < 0) {
                throw new IllegalArgumentException("Quantity cannot be negative: "
                        + tx.getQuantity());
            }
            if (storage.get(tx.getFruit()) > tx.getQuantity()) {
                storage.subtract(tx.getFruit(), tx.getQuantity());
            } else {
                throw new RuntimeException("Not enough " + tx.getFruit());
            }
        }
    }
}
