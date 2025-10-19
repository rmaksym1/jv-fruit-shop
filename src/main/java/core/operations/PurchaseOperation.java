package core.operations;

import core.basesyntax.FruitTransaction;
import core.basesyntax.StorageDao;
import core.interfaces.OperationHandler;

public class PurchaseOperation implements OperationHandler {

    @Override
    public void apply(FruitTransaction tx, StorageDao storageDao) {
        storageDao.subtract(tx.getFruit(), tx.getQuantity());
    }
}
