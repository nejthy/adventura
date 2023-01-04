package cz.vse.logika;

/**
 * Třída Hra - třída představující logiku adventury.
 * <p>
 * Toto je hlavní třída  logiky aplikace.  Tato třída vytváří instanci třídy HerniPlan, která inicializuje mistnosti hry
 * a vytváří seznam platných příkazů a instance tříd provádějící jednotlivé příkazy.
 * Vypisuje uvítací a ukončovací text hry.
 * Také vyhodnocuje jednotlivé příkazy zadané uživatelem.
 *
 * @author Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova, Natálie Kuželová
 * @version ZS 2022/23
 */

public class Hra implements IHra {


    private SeznamPrikazu platnePrikazy;

    private HerniPlan herniPlan;
    private Inventar inventar;
    private boolean konecHry = false;
    private Vec vec;


    /**
         *  Vytváří hru a inicializuje místnosti (prostřednictvím třídy HerniPlan) a seznam platných příkazů.
         */
        public Hra() {
            herniPlan = new HerniPlan();
            inventar = new Inventar(vec);
            platnePrikazy = new SeznamPrikazu();
            platnePrikazy.vlozPrikaz(new PrikazNapoveda(platnePrikazy));
            platnePrikazy.vlozPrikaz(new PrikazJdi(herniPlan,this, inventar, vec));
            platnePrikazy.vlozPrikaz(new PrikazKonec(this));
            platnePrikazy.vlozPrikaz(new PrikazSeber(herniPlan, inventar, this));
            platnePrikazy.vlozPrikaz(new PrikazPoloz(herniPlan, inventar, this, vec));
            platnePrikazy.vlozPrikaz(new PrikazInventar(inventar));
            platnePrikazy.vlozPrikaz(new PrikazSchovat(herniPlan, this, inventar));
            platnePrikazy.vlozPrikaz(new PrikazZautocit(herniPlan, vec, inventar, this));
            platnePrikazy.vlozPrikaz(new PrikazMluvit(herniPlan, this));
            platnePrikazy.vlozPrikaz(new PrikazZahraj(herniPlan));

        }

    /**
     *  Vrátí uvítácí zprávu pro hráče.
     */

        public String vratUvitani() {
        return "Vítej ve hře Vězení\n" +
                "\n" +
                "Nacházíš se právě v cele věznice. Do věznice se dostali tvý nepřátelé z dřívějších dob.\nVíš že už to je jenom otázka času, než ti někdo půjde po krku.\nRozhodneš se, že nejlepší věc co teď můžeš udělat, je se pokusit utéct.\nVíš že to nebude jednoduchý, ale lepší než zůstat a zemřít." +
                "\n\nNapiš 'nápověda', pokud si nevíš rady, jak hrát dál." +
                "\nPo cestě můžeš sbírat věci, které ti můžou v nějakých případech pomoct.\n" +
                herniPlan.getAktualniProstor().dlouhyPopis();
    };

    /**
     *  Vrátí závěrečnou zprávu pro hráče.
     */
    public String vratEpilog() {
        return "Tohle je konec hry. Díky že sis zahrál.";
    }


    /**
     * Vrací true, pokud hra skončila.
     */
    public boolean konecHry() {
        return konecHry;

    }
    /**
     * Metoda zpracuje řetězec uvedený jako parametr, rozdělí ho na slovo příkazu a další parametry.
     * Pak otestuje zda příkaz je klíčovým slovem  např. jdi.
     * Pokud ano spustí samotné provádění příkazu.
     * Dále pokud je hodnota 'jeVenku' true z HerniPlan, vypíše se zpráva a ukončí se hra.
     * @param radek text, který zadal uživatel jako příkaz do hry.
     * @return vrací se řetězec, který se má vypsat na obrazovku
     */
    public String zpracujPrikaz(String radek) {
        String[] slova = radek.split("[ \t]+");
        String slovoPrikazu = slova[0];
        String[] parametry = new String[slova.length - 1];
        for (int i = 0; i < parametry.length; i++) {
            parametry[i] = slova[i + 1];
        }
        String textKVypsani = " .... ";
        if (platnePrikazy.jePlatnyPrikaz(slovoPrikazu)) {
            IPrikaz prikaz = platnePrikazy.vratPrikaz(slovoPrikazu);
            textKVypsani = prikaz.provedPrikaz(parametry);
            if (herniPlan.jeVenku()) {
                textKVypsani = "Ještě že si tu sponu sebral a pomocí jí ses dostal zkrz dveře ven. Gratuluji, užívej svobodu.";
                konecHry = true;
            }
        } else {
            textKVypsani = "Tento příkaz neznám. Zkontroluj nápovědu, pokud nevíš jak dál.";
        }
        return textKVypsani;
    }


    /**
     * Nastaví, že je konec hry, metodu využívá třída PrikazKonec,
     * mohou ji použít i další implementace rozhraní Prikaz.
     *
     * @param konecHry hodnota false= konec hry, true = hra pokračuje
     */
    void setKonecHry(boolean konecHry) {
        this.konecHry = konecHry;
    }

    /**
     * Metoda vrátí odkaz na herní plán, je využita hlavně v testech,
     * kde se jejím prostřednictvím získává aktualní místnost hry.
     *
     * @return odkaz na herní plán
     */


    public HerniPlan getHerniPlan() {
        return herniPlan;
    }

}