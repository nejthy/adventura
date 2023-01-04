package cz.vse.logika;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PrikazZahrajTest {
    private Hra hra;




    @Before
    public void setUp() {
        hra = new Hra();

    }

    /***************************************************************************
     * Testuje příkaz zahraj, jestli to vypíše správné věci když se zahraj
     */

    @Test
    public void prikazZahrajTest() {
        Prostor hriste = new Prostor("hřiště", "kk");
        assertEquals("Prosím použijte příkaz bez dalších slov, děkuji.", hra.zpracujPrikaz("zahraj kokk"));
        assertEquals("Nemám zde co hrát.", hra.zpracujPrikaz("zahraj"));
        hra.getHerniPlan().setAktualniProstor(hriste);
        assertEquals("Šel sis zahrát fotbal s ostatními.\n" +
                "Najednou na zemi vidíš peníze. Třeba se budou hodit. Můžeš sebrat nebo nechat ležet.", hra.zpracujPrikaz("zahraj"));
    }
}
