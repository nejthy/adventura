package cz.vse.logika;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
/*******************************************************************************
 *
 * @author   Natálie Kuželová
 * @version  2022/2023
 */

public class PrikazInventarTest {
    private Hra hra;

    @Before
    public void setUp() {
        hra = new Hra();
    }



    @Test
    public void prikazInventarTest() {
        assertEquals("Velikost inventáře: 2\n" +
                "Předměty v inventáři: ", hra.zpracujPrikaz("inventář"));
    }
        }
