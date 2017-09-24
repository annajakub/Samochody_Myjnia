package fabryka;

import java.math.BigDecimal;

public class StacjaBenzynowa {

    PriceDB priceDB = new PriceDB ();


    private boolean powinienZatankowacDoPelna;
    private int dolanePaliwo;
    private Paliwo paliwo;

    public StacjaBenzynowa(Paliwo paliwo) {
        this.paliwo = paliwo;
    }

    public BigDecimal tankujDoPelna(Samochod samochod, Klient klient) {
        final BigDecimal roznicaBD;
        final int roznica = samochod.getMaxBak() - samochod.getAktualnaIloscPaliwa();
        roznicaBD = new BigDecimal(roznica);
        if ((roznicaBD.multiply(Paliwo.CENA_PALIWA)).compareTo(klient.getBudzet()) > 1) {
            System.out.println("Nie stac Cie na paliwo! ");
            return null;
        } else {
            samochod.setAktualnaIloscPaliwa(samochod.getAktualnaIloscPaliwa() + roznica);
        }return roznicaBD.multiply(Paliwo.CENA_PALIWA);
    }
    public BigDecimal coTansze (BigDecimal CENA_GAZU, BigDecimal CENA_PALIWA) {

        if (Paliwo.CENA_PALIWA.compareTo(Gaz.CENA_GAZU)> -1){
           return CENA_PALIWA;

        }else   {
            return CENA_GAZU;
        }

    }
}

