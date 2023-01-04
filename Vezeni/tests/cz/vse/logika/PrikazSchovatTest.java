package cz.vse.logika;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/*******************************************************************************
 *
 * @author   Natálie Kuželová
 * @version  2022/2023
 */

public class PrikazSchovatTest {

    private Hra hra;
    private HerniPlan herniPlan;




    @Before
    public void setUp() {
        hra = new Hra();
        herniPlan = new HerniPlan();

    }

    /***************************************************************************
     * Testuje příkaz schovat, jestli to vypíše správné věci když se hráč chce schovat
     * Zda funguje to, jestli když se chce schovat na místech, kde to nejde, tak ho to nepustí
     */

    @Test
    public void prikazSchovatTest() {
        Prostor sprchy = new Prostor("sprchy", "kk");
        Prostor cela = new Prostor("cela", "kk");
        Prostor hlavniMistnostStraze = new Prostor("hlavníMístnostStráže", "kk");
        hra.getHerniPlan().setAktualniProstor(sprchy);
        assertEquals("Postava se snažila schovat před druhým vězněm.\nBohužel to nestihla a byla bodnuta do zad.\nPomalu umíráš a vykrvácíš na zem.", hra.zpracujPrikaz("schovat"));
        hra.getHerniPlan().setAktualniProstor(hlavniMistnostStraze);
        assertEquals("Bohužel stráž tě viděla jak se schováváš. Ihned tě odvedli na samotku.\n Odsud už se nedostaneš. Smutné", hra.zpracujPrikaz("schovat"));
        assertEquals("Prosím použijte příkaz bez dalších slov, děkuji.", hra.zpracujPrikaz("schovat kk"));
        hra.getHerniPlan().setAktualniProstor(cela);
        assertEquals("Nemohu se zde schovat.", hra.zpracujPrikaz("schovat"));
    }
}
