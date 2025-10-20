package core.interfaces;

import core.basesyntax.FruitTransaction;

public interface OperationHandler {
    public void apply(FruitTransaction tx);
}
