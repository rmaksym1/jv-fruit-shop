package operations;

import service.impl.FruitTransaction;
import service.impl.StorageDao;
import interfaces.OperationHandler;
import interfaces.Storage;

public class PurchaseOperation implements OperationHandler {
    private final Storage storage;

    public PurchaseOperation(Storage storage) {
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
