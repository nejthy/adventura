package cz.vse.logika;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/*******************************************************************************
 *
 * @author   Natálie Kuželová
 * @version  2022/2023
 */

public class PrikazNapovedaTest {
    private Hra hra;


    @Before
    public void setUp() {
        hra = new Hra();
    }


    /***************************************************************************
     * Testuje zda příkaz nápověda vypíše správně nápovědu s platnými příkazy.
     */

    @Test
    public void prikazNapovedaTest() {
        assertEquals("Tvým úkolem je se dostat z vězení.\n"
                            + "Zkus jít do další místnosti.\n" +
                                "\n" +
                            "Můžeš zadat tyto příkazy:\n" +
                "polož mluv nápověda inventář schovat zaútočit zahraj jdi seber konec " , hra.zpracujPrikaz("nápověda"));
    }
}
