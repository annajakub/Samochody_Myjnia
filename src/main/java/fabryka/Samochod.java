package fabryka;

import java.math.BigDecimal;

public class Samochod {

    private Integer maxBak = 50;
    private int aktualnaIloscPaliwa;
    public int roznica;
    BigDecimal spalanie = new BigDecimal(20);
    private int distance;

    public Samochod(int aktualnaIloscPaliwa, BigDecimal spalanie, int distance) {
        this.aktualnaIloscPaliwa = aktualnaIloscPaliwa;
        this.spalanie = spalanie;
        this.distance = distance;
    }

    public int getRoznica() {
        return roznica;
    }

    public void setRoznica(int roznica) {
        this.roznica = roznica;
    }

    public BigDecimal getSpalanie() {
        return spalanie;
    }

    public void setSpalanie(BigDecimal spalanie) {
        this.spalanie = spalanie;
    }


    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Samochod(int aktualnaIloscPaliwa, int maxBak) {
        this.maxBak = maxBak;
        this.aktualnaIloscPaliwa = aktualnaIloscPaliwa;
    }

    public int getAktualnaIloscPaliwa() {
        return aktualnaIloscPaliwa;
    }

    public void setAktualnaIloscPaliwa(int aktualnaIloscPaliwa) {
        this.aktualnaIloscPaliwa = aktualnaIloscPaliwa;
    }

    public Integer getMaxBak() {
        return maxBak;
    }

    public int tankujRoznice(int roznica) {
        roznica = getMaxBak() - getAktualnaIloscPaliwa();
        return roznica;
    }


    public boolean isZatankowanyDoPelana() {
        if ((getAktualnaIloscPaliwa() + roznica) == getMaxBak()) {
            return true;
        } else {
            return false;
        }

    }

    public boolean isPrzelany() {
        if (aktualnaIloscPaliwa > maxBak) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isPustyBak() {
        if (aktualnaIloscPaliwa == 0) {
            return true;
        } else {
            return false;
        }


    }

    public boolean isDirty() {
        boolean dirty = false;
        if (dirty) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isGlossy() {
        boolean gloss = false;
        if (gloss) {
            return true;
        } else {
            return false;
        }
    }

//    public int IlePrzejedzie(BigDecimal spalanie, int distance, int aktualnaIloscPaliwa ){
//
//        int iloscPrzejechanychKM = ((BigDecimal)aktualnaIloscPaliwa.divide  getSpalanie()*100);
//        return iloscPrzejechanychKM;
}



