package cz.vse.logika;

/**
 *  Třída PrikazZahraj - slouží zahrání si fotbalu na hřišti.
 *
 *@author     Natálie Kuželová
 *@version    2022/2023
 */


public class PrikazZahraj implements IPrikaz{
    private HerniPlan herniPlan;


    public PrikazZahraj(HerniPlan herniPlan) {
        this.herniPlan = herniPlan;
    }

    private static final String NAZEV = "zahraj";


    /**
     * Tato metoda umožní hráči hrát fotbal na hřišti
     * @param parametry bez parametru
     * @return zpráva, která je vypsaná hráči. Nebo chybná zpráva při zadání neznámého parametru.
     */

    @Override
    public String provedPrikaz(String... parametry) {


        Prostor aktualniProstor  = herniPlan.getAktualniProstor();
        Vec vec = new Vec("peníze",true);

        if (parametry.length == 0 && (herniPlan.getAktualniProstor().getNazev().equals("hřiště"))) {
            aktualniProstor.setVec(vec);
            return "Šel sis zahrát fotbal s ostatními.\n" +
                    "Najednou na zemi vidíš peníze. Třeba se budou hodit. Můžeš sebrat nebo nechat ležet.";

        } else if (parametry.length >= 1) {
            return "Prosím použijte příkaz bez dalších slov, děkuji.";
        } else {
            return  "Nemám zde co hrát.";
        }
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
