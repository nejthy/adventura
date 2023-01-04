package cz.vse.logika;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PrikazJdiTest {
    private Hra hra;

    @Before
    public void setUp() {
        hra = new Hra();
    }


    /***************************************************************************
     * Testuje příkaz jdi, jestli se dá jít do další místnosti.
     * a jestli to vrací to správné
     */


    @Test
    public void prikazJdiTest() {
        Prostor cela = new Prostor("cela", "cela, odsud můžeš jít jenom na chodbu");
        assertEquals("cela", hra.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals("Kam mám jít? Musíš zadat jméno východu", hra.zpracujPrikaz("jdi"));
        assertEquals("Tam se odsud jít nedá!", hra.zpracujPrikaz("jdi jídelna a chodba"));
        assertEquals("Tam se odsud jít nedá!", hra.zpracujPrikaz("jdi koupelna"));

        }

    }

