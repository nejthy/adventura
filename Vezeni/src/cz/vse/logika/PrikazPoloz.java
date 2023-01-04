package cz.vse.logika;

/**
 *  Třída PrikazPoloz - slouží k pokládání věcí z inventáře.
 *
 *@author     Natálie Kuželová
 *@version    2022/2023
 */

public class PrikazPoloz implements IPrikaz {

    private final HerniPlan herniPlan;
    private final Inventar inventar;
    private final Hra hra;

    private final Vec vec;



    public PrikazPoloz(HerniPlan herniPlan, Inventar inventar, Hra hra, Vec vec) {
        this.herniPlan = herniPlan;
        this.inventar = inventar;
        this.hra = hra;
        this.vec = vec;
    }

    private static final String NAZEV = "polož";

    /**
     * Tato metoda pokládá věci z inventáře
     * @param parametry (název věci)
     * @return zpráva, která je vypsaná hráči. Nebo chybná zpráva při zadání neznámého parametru.
     */

    @Override
    public String provedPrikaz(String... parametry) {

        if (parametry.length == 0) {
            return "Nevím co mám položit, prosím zadej název věci.";
        } else if (parametry.length > 1) {
            return "Není možné položit více než jednu věc najednou";
        }


        String nazevVeci = parametry[0];
        Prostor aktualniProstor  = herniPlan.getAktualniProstor();
        Vec vec = inventar.getVec(nazevVeci);


        if (inventar.inventarJePrazdny()) {
            return "Inventář je prázdný, nemáš co položit";}

        else {
            inventar.odeberVec(nazevVeci);
            aktualniProstor.setVec(vec);
            return "Věc " + nazevVeci + " byla položena.";
        }
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
