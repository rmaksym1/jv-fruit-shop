package core.operations;

import core.basesyntax.FruitTransaction;
import core.basesyntax.StorageDao;
import core.interfaces.OperationHandler;

public class SupplyOperation implements OperationHandler {

    @Override
    public void apply(FruitTransaction tx, StorageDao storageDao) {
        storageDao.add(tx.getFruit(), tx.getQuantity());
    }
}
