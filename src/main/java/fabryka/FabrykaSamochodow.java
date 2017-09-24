package fabryka;

public class FabrykaSamochodow {    //Fasada
    StacjaBenzynowa stacjaBenzynowa = new StacjaBenzynowa(new Paliwo(1));
    Myjnia myjnia = new Myjnia();
    Lakiernia lakiernia = new Lakiernia();
    Montazownia montazownia = new Montazownia();
    public void clean(Samochod samochod) {
        if(myjnia.sprawdzLakier()) {
            myjnia.mycieZpolyskiem(samochod);
        }else {

        }

    }
    public void paint(){

    }
    public void create(){

    }


}
