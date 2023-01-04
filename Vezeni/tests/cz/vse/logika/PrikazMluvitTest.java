package cz.vse.logika;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
/*******************************************************************************
 *
 * @author   Natálie Kuželová
 * @version  2022/2023
 */

public class PrikazMluvitTest {

    private Hra hra;
    private Prostor prostor;


    @Before
    public void setUp() {
        hra = new Hra();
        prostor = new Prostor("hriste", "kk");
        hra.getHerniPlan().setAktualniProstor(prostor);

    }

    /***************************************************************************
     * Testuje zda hráč může mluvit s osobami v daných místnostech.
     */

    @Test
    public void prikazMluvTest() {
        Postava Bill = new Postava("Bill", "Hello");
        prostor.vlozPostavu(Bill);
        assertEquals("Nevím koho se mám zeptat. Napiš jméno postavy.", hra.zpracujPrikaz("mluv"));
        assertEquals("Není možné se ptát více lidí najednou", hra.zpracujPrikaz("mluv Naty a Venda"));
        assertEquals("Takováhle postava tu není", hra.zpracujPrikaz("mluv Naty"));
        assertEquals("Hello" , hra.zpracujPrikaz("mluv Bill"));
    }
}
