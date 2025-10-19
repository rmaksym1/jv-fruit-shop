package core.interfaces;

import core.basesyntax.FruitTransaction;
import core.basesyntax.StorageDao;

import java.util.Map;

public interface OperationHandler {
    public void apply(FruitTransaction tx, StorageDao storageDao);
}
