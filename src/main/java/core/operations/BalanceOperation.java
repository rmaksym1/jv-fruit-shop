package core.operations;

import core.basesyntax.FruitTransaction;
import core.basesyntax.StorageDao;
import core.interfaces.OperationHandler;

public class BalanceOperation implements OperationHandler {

    @Override
    public void apply(FruitTransaction tx, StorageDao storageDao) {
        if (tx != null && tx.getQuantity() >= 0) {
            storageDao.set(tx.getFruit(), tx.getQuantity());
        }
    }
}
