package cz.vse.logika;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
/*******************************************************************************
 *
 * @author   Natálie Kuželová
 * @version  2022/2023
 */

public class HerniPlanTest {
    private HerniPlan herniPlan;

    @Before
    public void setUp() {
        herniPlan = new HerniPlan();
    }
    /***************************************************************************
     * Testuje zda když se založí prostor, jestli se opravdu založí v herním plánu
     */

    @Test
    public void herniPlanTest() {
        Prostor sprchy = new Prostor("sprchy", "kk");
        herniPlan.setAktualniProstor(sprchy);
        assertEquals(sprchy, herniPlan.getAktualniProstor());
    }

}


