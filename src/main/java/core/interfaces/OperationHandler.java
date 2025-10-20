package core.interfaces;

import core.basesyntax.FruitTransaction;
import core.basesyntax.StorageDao;

public interface OperationHandler {
    public void apply(FruitTransaction tx);
}
