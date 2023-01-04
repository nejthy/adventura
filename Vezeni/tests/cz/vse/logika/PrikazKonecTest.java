package cz.vse.logika;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
/*******************************************************************************
 *
 * @author   Natálie Kuželová
 * @version  2022/2023
 */

public class PrikazKonecTest {

    private Hra hra;

    @Before
    public void setUp() {
        hra = new Hra();

    }

    /***************************************************************************
     * Testuje zda příkaz konec ukonší hru.
     */

    @Test
    public void prikazMluvTest() {
        assertEquals("Ukončit co? Nechápu, proč jste zadal druhé slovo.", hra.zpracujPrikaz("konec kk"));
        assertEquals("hra ukončena příkazem konec", hra.zpracujPrikaz("konec"));

    }
}
