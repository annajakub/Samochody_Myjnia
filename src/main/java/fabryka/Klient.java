package fabryka;

import java.math.BigDecimal;

public class Klient {
   BigDecimal budzet = new BigDecimal("100");


    public BigDecimal getBudzet() {
        return budzet;
    }

    public void setBudzet(BigDecimal budzet) {
        this.budzet = budzet;
    }
}

