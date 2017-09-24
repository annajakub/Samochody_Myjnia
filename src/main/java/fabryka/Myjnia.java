package fabryka;

import java.math.BigDecimal;

class Myjnia {


    public boolean sprawdzLakier() {
        return true;
    }

    public void mycieZpolyskiem(Samochod samochod) {
    }

    public static void main(String[] args) {
        OperationCleaningStrategyContext context = new OperationCleaningStrategyContext(new SuperCleaning());
        context = new OperationCleaningStrategyContext(new StandardCleaning()); //nasz Context to OperationCleaningContext (nie importujemy classy Context z Javy)
        Samochod samochod = new Samochod(40, new BigDecimal(5), 50);
        samochod.isDirty();
        samochod.isGlossy();
        context.executeStrategy(samochod);

        //mozna dodac Singleton, aby nie tworzyć ciągle nowych obiektów, tylko pobrać instancje
    }
}

