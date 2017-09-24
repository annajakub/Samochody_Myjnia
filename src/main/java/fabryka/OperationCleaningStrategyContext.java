package fabryka;

import javax.naming.Context;

public class OperationCleaningStrategyContext {
    private Strategy strategy;

    public OperationCleaningStrategyContext(Strategy strategy) {
        this.strategy = strategy;
    }
    public  Samochod executeStrategy (Samochod samochod){
        return strategy.doCleanig(samochod);
    }
}