package cz.vse.logika;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
/*******************************************************************************
 *
 * @author   Natálie Kuželová
 * @version  2022/2023
 */

public class PrikazPolozTest {
    private Hra hra;
    private Inventar inventar;

    @Before
    public void setUp() {
        hra = new Hra();
    }

    /***************************************************************************
     * Testuje zda jdou dané věci v inventráři položit.
     */

    @Test
    public void prikazPolozTest() {
        assertEquals("Nevím co mám položit, prosím zadej název věci.", hra.zpracujPrikaz("polož"));
        assertEquals("Není možné položit více než jednu věc najednou", hra.zpracujPrikaz("polož kolotoc a batoh"));
        assertEquals("Inventář je prázdný, nemáš co položit", hra.zpracujPrikaz("polož kolotoc"));
        hra.zpracujPrikaz("seber šroubovák");
        assertEquals("Věc šroubovák byla položena.", hra.zpracujPrikaz("polož šroubovák"));
    }
}
