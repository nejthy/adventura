package cz.vse.logika;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*******************************************************************************
 * Testovací třída HraTest slouží ke komplexnímu otestování
 * třídy Hra
 *
 * @author    Jarmila Pavlíčková
 * @author    Natálie Kuželová
 * @version  pro školní rok 2022/2023
 */

public class HraTest {

    private Hra hra;

    //== Datové atributy (statické i instancí)======================================

    //== Konstruktory a tovární metody =============================================
    //-- Testovací třída vystačí s prázdným implicitním konstruktorem ----------

    //== Příprava a úklid přípravku ================================================

    /***************************************************************************
     * Metoda se provede před spuštěním každé testovací metody. Používá se
     * k vytvoření tzv. přípravku (fixture), což jsou datové atributy (objekty),
     * s nimiž budou testovací metody pracovat.
     */
    @Before
    public void setUp() {
        hra = new Hra();
    }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každé testovací metody.
     */
    @After
    public void tearDown() {
    }

    //== Soukromé metody používané v testovacích metodách ==========================

    //== Vlastní testovací metody ==================================================

    /***************************************************************************
     * Testuje průběh hry, po zavolání každěho příkazu testuje, zda hra končí
     * a v jaké aktuální místnosti se hráč nachází.
     * Při dalším rozšiřování hry doporučujeme testovat i jaké věci nebo osoby
     * jsou v místnosti a jaké věci jsou v batohu hráče.
     *
     */
    @Test
    public void testPrubehHry() {
        assertEquals("cela", hra.getHerniPlan().getAktualniProstor().getNazev());
        hra.zpracujPrikaz("jdi chodba");
        assertEquals(false, hra.konecHry());
        assertEquals("chodba", hra.getHerniPlan().getAktualniProstor().getNazev());
        hra.zpracujPrikaz("jdi jídelna");
        assertEquals(false, hra.konecHry());
        assertEquals("jídelna", hra.getHerniPlan().getAktualniProstor().getNazev());
        hra.zpracujPrikaz("jdi hlavníMístnostStráže");
        assertEquals(false, hra.konecHry());
        assertEquals("hlavníMístnostStráže", hra.getHerniPlan().getAktualniProstor().getNazev());
        hra.zpracujPrikaz("konec");
        assertEquals(true, hra.konecHry());
    }
}
