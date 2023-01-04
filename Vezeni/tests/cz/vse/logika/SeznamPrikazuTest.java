package cz.vse.logika;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SeznamPrikazuTest
{
    private Hra hra;
    private PrikazKonec prKonec;
    private PrikazJdi prJdi;
    private Inventar inventar;
    private Vec vec;

    @Before
    public void setUp() {
        hra = new Hra();
        prKonec = new PrikazKonec(hra);
        prJdi = new PrikazJdi(hra.getHerniPlan(), hra, inventar, vec);
    }

    @org.junit.Test
    public void testVlozeniVybrani() {
        SeznamPrikazu seznPrikazu = new SeznamPrikazu();
        seznPrikazu.vlozPrikaz(prKonec);
        seznPrikazu.vlozPrikaz(prJdi);
        Assert.assertEquals(prKonec, seznPrikazu.vratPrikaz("konec"));
        Assert.assertEquals(prJdi, seznPrikazu.vratPrikaz("jdi"));
        Assert.assertEquals(null, seznPrikazu.vratPrikaz("nápověda"));
    }
    @org.junit.Test
    public void testJePlatnyPrikaz() {
        SeznamPrikazu seznPrikazu = new SeznamPrikazu();
        seznPrikazu.vlozPrikaz(prKonec);
        seznPrikazu.vlozPrikaz(prJdi);
        Assert.assertEquals(true, seznPrikazu.jePlatnyPrikaz("konec"));
        Assert.assertEquals(true, seznPrikazu.jePlatnyPrikaz("jdi"));
        Assert.assertEquals(false, seznPrikazu.jePlatnyPrikaz("nápověda"));
        Assert.assertEquals(false, seznPrikazu.jePlatnyPrikaz("Konec"));
    }

    @Test
    public void testNazvyPrikazu() {
        SeznamPrikazu seznPrikazu = new SeznamPrikazu();
        seznPrikazu.vlozPrikaz(prKonec);
        seznPrikazu.vlozPrikaz(prJdi);
        String nazvy = seznPrikazu.vratNazvyPrikazu();
        Assert.assertEquals(true, nazvy.contains("konec"));
        Assert.assertEquals(true, nazvy.contains("jdi"));
        Assert.assertEquals(false, nazvy.contains("nápověda"));
        Assert.assertEquals(false, nazvy.contains("Konec"));
    }

}
