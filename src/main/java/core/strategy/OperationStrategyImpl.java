package core.strategy;

import core.basesyntax.FruitTransaction;
import core.interfaces.OperationHandler;
import core.interfaces.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation,
            OperationHandler> handlers;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> handlers) {
        this.handlers = handlers;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation op) {
        if (handlers.get(op) == null) {
            throw new IllegalArgumentException(String.format("Operation %s not found", op));
        }
        return handlers.get(op);
    }
}
