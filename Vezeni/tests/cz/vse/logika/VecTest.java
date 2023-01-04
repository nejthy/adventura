package cz.vse.logika;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/*******************************************************************************
 *
 * @author   Natálie Kuželová
 * @version  2022/2023
 * Testovací třída VecTest slouží ke komplexnímu otestování
 * třídy vec
 */

public class VecTest {

    private Vec vec;

    /***************************************************************************
     * Testuje věci, jestli věc vrací správný název a jestli je sebratelná
     */

    @Test
    public void vecTest() {
        Vec tyc = new Vec("tyc", true);
        assertEquals("tyc", tyc.getNazev());
        assertEquals(true, tyc.isPrenositelna());
        Vec auto = new Vec("auto", false);
        assertEquals(false, auto.isPrenositelna());
    }
}
