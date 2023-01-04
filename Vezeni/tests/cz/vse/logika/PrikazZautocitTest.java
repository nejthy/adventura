package cz.vse.logika;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/*******************************************************************************
 *
 * @author   Natálie Kuželová
 * @version  2022/2023
 */

public class PrikazZautocitTest {

    private Hra hra;
    private HerniPlan herniPlan;
    private Prostor prostor;



    @Before
    public void setUp() {
        hra = new Hra();
        herniPlan = new HerniPlan();
    }

    /***************************************************************************
     * Testuje příkaz zaútočit, jestli to vypíše správné věci když se zaútočí
     */

    @Test
    public void prikazZautocitTest() {
        Prostor sprchy = new Prostor("sprchy", "kk");
        Postava John = new Postava("John", "Hh");
        assertEquals("Nevím na koho mám zautocit. Napiš jméno postavy.", hra.zpracujPrikaz("zaútočit"));
        assertEquals("Není možné útočit na více lidí najednou.", hra.zpracujPrikaz("zaútočit Jeremy a Cole"));
        assertEquals("Takováhle postava tu není", hra.zpracujPrikaz("zaútočit John"));
        hra.zpracujPrikaz("seber šroubovák");
        hra.getHerniPlan().setAktualniProstor(sprchy);
        sprchy.vlozPostavu(John);
        assertEquals("Byl si rychlý a dokázal si týpka John zabodnout. Zároveň tím pádem spadnul nůž na zem s kterým na tebe šel.\n" +
                "Třeba se ti bude hodit, třeba ne.", hra.zpracujPrikaz("zaútočit John"));
        sprchy.vlozPostavu(John);
        hra.getHerniPlan().setAktualniProstor(sprchy);
        hra.zpracujPrikaz("polož šroubovák");
        assertEquals("Snažil si se zaútočit, bohužel máš jen svoje ruce a to nestačí. Byl si zabit", hra.zpracujPrikaz("zaútočit John"));
    }
}
