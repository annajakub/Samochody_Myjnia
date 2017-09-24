import fabryka.FabrykaSamochodow;
import fabryka.Samochod;

import java.math.BigDecimal;

public class KlientFabryki {


    public static void main(String[] args) {
        FabrykaSamochodow fabrykaSamochodow = new FabrykaSamochodow();
        Samochod samochod = new Samochod(22,new BigDecimal(3), 4);

        fabrykaSamochodow.clean(samochod);
    }
}
