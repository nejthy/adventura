package cz.vse.logika;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;

/*******************************************************************************
 * Testovací třída InventarTest slouží ke komplexnímu otestování
 * třída Inventář
 * @author   Natálie Kuželová
 * @version  2022/2023
 */
public class InventarTest {

    private Inventar inventar;

    private Vec vec;



    @Before
    public void setUp() {
        inventar = new Inventar(vec);
    }


    /***************************************************************************
     * Testuje inventář, jestli do něj jdou dát věci
     * a zároveň jestli jdou odebrat
     */
    @Test
    public void testInventar() {
        Vec barel = new Vec("barel", true);
        inventar.vlozVec(barel);
        assertTrue(inventar.obsahujeVec("barel"));
        assertEquals("Předměty v inventáři: barel, ", inventar.obsahInventare());
        inventar.odeberVec("barel");
        assertFalse(inventar.obsahujeVec("barel"));

    }
}
