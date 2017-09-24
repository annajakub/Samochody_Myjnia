package fabryka;

import java.math.BigDecimal;

public class Paliwo {

    public static final BigDecimal CENA_PALIWA = new BigDecimal("5.7");

    private int woda;

    public Paliwo(int woda) {
        this.woda = woda;
    }

    public double getWoda(int woda) {
        return woda;
    }
    public void setWoda(int woda) {
        this.woda = woda;
    }

    public boolean isCzyChrzczone() {
        if (woda > 0) {
            return true;
        } else
            return false;

    }
}
