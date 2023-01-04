package cz.vse.logika;

/**
 *  Třída PrikazSeber - slouží k sebrání věcí v nějakých místnostech.
 *
 *@author     Natálie Kuželová
 *@version    2022/2023
 */


public class PrikazSeber implements IPrikaz{
    private final HerniPlan herniPlan;
    private final Inventar inventar;
    private final Hra hra;

    public PrikazSeber(HerniPlan herniPlan, Inventar inventar, Hra hra) {
        this.herniPlan = herniPlan;
        this.inventar = inventar;
        this.hra = hra;
    }

    /**
     * Tato metoda sbírá věci a přídává je do invetáře
     * @param parametry (název věci)
     * @return zpráva, která je vypsaná hráči. Nebo chybná zpráva při zadání neznámého parametru.
     */
    private static final String NAZEV = "seber";
    @Override
    public String provedPrikaz(String... parametry) {

        if (parametry.length == 0) {
            return "Nevím co mám sebrat, prosím zadej název věci.";
        } else if (parametry.length > 1) {
            return "Není možné sebrat více než jednu věc";
        }

        String nazevVeci = parametry[0];
        Prostor aktualniProstor  = herniPlan.getAktualniProstor();
        Vec vec = aktualniProstor.ziskejVec(nazevVeci);

        if (vec == null) {
            return nazevVeci + " tu není ";  }
       else if (!inventar.inventarJePlny()) {
            return "Inventář je plný, už do něj nic nenarveš";}

        else if (!vec.isPrenositelna()) {
            return "Tuhle věc bohužel sebrat nemůžeš";
        }
        else {
            inventar.vlozVec(vec);
            aktualniProstor.odstranVec(nazevVeci);
            return "Věc " + nazevVeci + " byla sebrána.";
        }
    }


    @Override
    public String getNazev() {
        return NAZEV;
    }
}
