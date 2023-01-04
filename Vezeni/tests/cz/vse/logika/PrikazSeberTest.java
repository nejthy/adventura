package cz.vse.logika;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/*******************************************************************************
 *
 * @author   Natálie Kuželová
 * @version  2022/2023
 */

public class PrikazSeberTest {
    private Hra hra;
    private Prostor prostor;
    private Inventar inventar;
    private Vec vec;
    private HerniPlan herniPlan;

    @Before
    public void setUp() {
        hra = new Hra();
        inventar = new Inventar(vec);
        prostor = new Prostor ("sprchy", "kk");
        hra.getHerniPlan().setAktualniProstor(prostor);
    }

    /***************************************************************************
     * Testuje zda dané věci jsou sebrat či nikoli.
     * Také jestli dané věci, které se nenachází v prostoru jdou sebrat
     */

    @Test
    public void prikazSeberTest() {
        Vec skrin = new Vec("skrin", false);
        Vec lopata = new Vec("lopata", true);
        prostor.setVec(skrin);
        prostor.setVec(lopata);
        assertEquals("Nevím co mám sebrat, prosím zadej název věci.", hra.zpracujPrikaz("seber"));
        assertEquals("Není možné sebrat více než jednu věc", hra.zpracujPrikaz("seber lopatu a skrin"));
        assertEquals("kolecko tu není ", hra.zpracujPrikaz("seber kolecko"));
        assertEquals("Tuhle věc bohužel sebrat nemůžeš", hra.zpracujPrikaz("seber skrin"));
        assertEquals("Věc lopata byla sebrána.", hra.zpracujPrikaz("seber lopata"));

        }
    }

