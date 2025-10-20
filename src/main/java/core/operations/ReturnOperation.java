package core.operations;

import core.basesyntax.FruitTransaction;
import core.basesyntax.StorageDao;
import core.interfaces.OperationHandler;

public class ReturnOperation implements OperationHandler {
    private final StorageDao storage;

    public ReturnOperation(StorageDao storage) {
        this.storage = storage;
    }

    @Override
    public void apply(FruitTransaction tx) {
        if (tx != null) {
            storage.add(tx.getFruit(), tx.getQuantity());
        }
    }
}
