import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import fabryka.Gaz;
import fabryka.Klient;
import fabryka.Paliwo;
import fabryka.Samochod;
import fabryka.StacjaBenzynowa;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withinPercentage;

@RunWith(DataProviderRunner.class)
public class StacjaBenzynowaTest {

    StacjaBenzynowa stacjaBenzynowa;

    @Before
    public void setUp() throws Exception {
        Paliwo paliwo = new Paliwo(0);
        stacjaBenzynowa = new StacjaBenzynowa(paliwo);
    }

    @Test
    public void powinienZatankowacDoPelna() {

        Samochod samochod = new Samochod(10, 50);

        Klient klient = new Klient();
        stacjaBenzynowa.tankujDoPelna(samochod, klient);
        Assert.assertTrue(samochod.isZatankowanyDoPelana());

        assertThat(samochod.isZatankowanyDoPelana()).isTrue();

    }

    @Test
    public void czyNiePrzeleje() {
        Samochod samochod2 = new Samochod(60, 50);
      //  fabryka.StacjaBenzynowa stacjaBenzynowa2 = new fabryka.StacjaBenzynowa(new fabryka.Paliwo(0));
        Assert.assertTrue(samochod2.isPrzelany());
    }

    @Test
    public void czyPustyBak() {
        Samochod samochod3 = new Samochod(0, 50);
       // fabryka.StacjaBenzynowa stacjaBenzynowa3 = new fabryka.StacjaBenzynowa(new fabryka.Paliwo(0));
        Assert.assertTrue(samochod3.isPustyBak());
    }

    @Test
    public void czyChrzczona() {
        Paliwo paliwo = new Paliwo(1);
     //   fabryka.StacjaBenzynowa stacjaBenzynowa4 = new fabryka.StacjaBenzynowa(paliwo);
        Assert.assertTrue(paliwo.isCzyChrzczone());
    }

    @Test
    public void czyMaszKase() {
        Klient klient = new Klient();
        Samochod samochod4 = new Samochod(10, 50);
        Assertions.assertThat(stacjaBenzynowa.tankujDoPelna(samochod4, klient)).isPositive();
    }

    @Test
    public void coTansze() {
        Paliwo paliwo2 = new Paliwo(0);
        Gaz gaz = new Gaz ();

        assertThat(gaz).isEqualToComparingFieldByFieldRecursively(paliwo2);
    }


    @DataProvider
    public static Object[][] dataProviderTankowanie() {
        return new Object[][] {
                { 10, 40, new BigDecimal(228) },
                { 0, 50, new BigDecimal(285) },
                { 50, 0, new BigDecimal(0) },
                { 60, 110, new BigDecimal(2) },
        };
    }

    @Test
    @UseDataProvider("dataProviderTankowanie")
    public void shouldCount(int aktualnaIloscPaliwa, int roznica, BigDecimal cenaZakupionegoPaliwa) {
        //Given
        Samochod samochod = new Samochod(aktualnaIloscPaliwa, 50);
        Klient klient = new Klient();
        klient.setBudzet(new BigDecimal(500));
        //When
        BigDecimal result = stacjaBenzynowa.tankujDoPelna(samochod,klient );
        //Then
        Assertions.assertThat(result).isCloseTo(cenaZakupionegoPaliwa, withinPercentage(0) );
    }
//     public class MockitoTest {
//        @Mock
//         MyDatabase databaseMock;
//
//        @Rule
//        public MockitoRule mockitoRule = MockitoJunit.rule();
//
//        @Test
//        public void  shouldShowPriceForRefuel () {
//            //given
//            fabryka.Samochod samochod = new fabryka.Samochod(10, 50);
//
//            //When
//            fabryka.StacjaBenzynowa.showPriceForFullRefuel(samochod);
//            //then
//            //tu sprawdzamy
//        }
   //  }



    @DataProvider
    public static Object[][] dataProviderIlePrzejedzie() {
        return new Object[][] {
                { 8, 40, 228 },
                { 7, 10, 1000},
                { 10, 80, 50},
                { 60, 110, 2},
        };
    }

    @Test
    @UseDataProvider("dataProviderIlePrzejedzie")
    public void shouldCountIlePrzejedzie(int aktualnaIloscPaliwa,BigDecimal spalanie,  int distance ) {
        //Given
        Samochod samochod = new Samochod(14, new BigDecimal(8), 54);
        Klient klient = new Klient();
        klient.setBudzet(new BigDecimal(500));
        //When
        BigDecimal result = stacjaBenzynowa.tankujDoPelna(samochod,klient );
        //Then
      //  Assertions.assertThat(result).isCloseTo(cenaZakupionegoPaliwa, withinPercentage(0) );
    }


}


