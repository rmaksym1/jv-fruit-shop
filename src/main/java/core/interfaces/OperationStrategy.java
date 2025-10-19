package core.interfaces;

import core.basesyntax.FruitTransaction;

public interface OperationStrategy {
    public OperationHandler get(FruitTransaction.Operation op);
}
