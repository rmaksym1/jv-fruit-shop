package core.operations;

import core.basesyntax.FruitTransaction;
import core.basesyntax.StorageDao;
import core.interfaces.OperationHandler;

public class PurchaseOperation implements OperationHandler {
    private final StorageDao storage;

    public PurchaseOperation(StorageDao storage) {
        this.storage = storage;
    }

    @Override
    public void apply(FruitTransaction tx) {
        if (tx != null) {
            if (storage.get(tx.getFruit()) > tx.getQuantity()) {
                storage.subtract(tx.getFruit(), tx.getQuantity());
            } else {
                throw new RuntimeException("Not enough " + tx.getFruit());
            }
        }
    }
}
