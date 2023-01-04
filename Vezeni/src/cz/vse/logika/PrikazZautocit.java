package cz.vse.logika;

/**
 *  Třída PrikazZautocit - slouží k zaútočení na postavu.
 *
 *@author     Natálie Kuželová
 *@version    2022/2023
 */

public class PrikazZautocit implements IPrikaz{


    private static final String NAZEV = "zaútočit";

    private HerniPlan herniPlan;

    private final Vec vec;

    private Inventar inventar;
    private Hra hra;


    public PrikazZautocit(HerniPlan herniPlan, Vec vec, Inventar inventar, Hra hra) {
        this.herniPlan = herniPlan;
        this.vec = vec;
        this.inventar = inventar;
        this.hra = hra;
    }


    /**
     * Tato metoda umožní hráči zaútočit na postavu
     * @param parametry (jméno postavy)
     * @return zpráva, která je vypsaná hráči. Nebo chybná zpráva při zadání neznámého parametru.
     */


    public String provedPrikaz(String... parametry) {

        if (parametry.length == 0) {
            return "Nevím na koho mám zautocit. Napiš jméno postavy.";
        } else if (parametry.length > 1) {
            return "Není možné útočit na více lidí najednou.";
        }

        String jmenoPostavy = parametry[0];
        Prostor aktualniProstor  = herniPlan.getAktualniProstor();
        Postava postava = aktualniProstor.ziskejPostavu(jmenoPostavy);
        Vec vec = new Vec("nůž",true);

        if (postava == null) {
            return  "Takováhle postava tu není" ;
        } else if (inventar.obsahujeVec("šroubovák") && (herniPlan.getAktualniProstor().getNazev().equals("sprchy"))) {
           aktualniProstor.odstranPostavu(jmenoPostavy);
            aktualniProstor.setVec(vec);
            return "Byl si rychlý a dokázal si týpka " + jmenoPostavy + " zabodnout. Zároveň tím pádem spadnul nůž na zem s kterým na tebe šel.\nTřeba se ti bude hodit, třeba ne.";
        }
        else if (inventar.obsahujeVec("kladivo") && (herniPlan.getAktualniProstor().getNazev().equals("sprchy"))) {
            aktualniProstor.odstranPostavu(jmenoPostavy);
            inventar.odeberVec("kladivo");
            return "Byl si rychlý a dokázal si týpka " + jmenoPostavy + " kladivem zabít až se ti z toho zničilo a ztrácíš ho.";

    } else if (inventar.obsahujeVec("šroubovák") || inventar.obsahujeVec("kladivo") && (herniPlan.getAktualniProstor().getNazev().equals("hlavniMistnostStraze") )) {
           hra.setKonecHry(true);
            return "Hezký pokus jednoho si zabil, ale přiběhla hned další stráž a dala tě na samotku.\nTeď už se pryč nedostaneš";
        } else {
            hra.setKonecHry(true);
            return "Snažil si se zaútočit, bohužel máš jen svoje ruce a to nestačí. Byl si zabit";
        }
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
