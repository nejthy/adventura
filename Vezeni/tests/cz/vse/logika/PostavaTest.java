package cz.vse.logika;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/*******************************************************************************
 *
 * @author   Natálie Kuželová
 * @version  2022/2023
 */
public class PostavaTest {

    private HerniPlan herniPlan;
    private Postava postava;


    @Before
    public void setUp() {
        postava = new Postava("Jeremy", "Zabiju tě!!!");
    }

    @Test
    public void postavaTest() {
        assertEquals("Jeremy", postava.getJmenoPostava());
        assertEquals("Zabiju tě!!!", postava.getProslov());
    }
}
