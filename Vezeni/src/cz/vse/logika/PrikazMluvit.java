package cz.vse.logika;

/*******************************************************************************
 *
 * @author   Natálie Kuželová
 * @version  2022/2023
 */

public class PrikazMluvit implements IPrikaz{

    private final HerniPlan herniPlan;
    private final Hra hra;

    public PrikazMluvit(HerniPlan herniPlan, Hra hra) {
        this.herniPlan = herniPlan;
        this.hra = hra;
    }

    private static final String NAZEV = "mluv";

    /**
     * Provádí příkaz "mluv". Tím může hráč mluvit s postavami
     *
     * @param parametry (jaka parametr obsahuje název postavy)
     * @return proslov, který má ta daná postava)
     */

    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            return "Nevím koho se mám zeptat. Napiš jméno postavy.";
        } else if (parametry.length > 1) {
            return "Není možné se ptát více lidí najednou";
        }

        String jmenoPostavy = parametry[0];
        Prostor aktualniProstor  = herniPlan.getAktualniProstor();
        Postava postava = aktualniProstor.ziskejPostavu(jmenoPostavy);

        if (postava == null) {
            return  "Takováhle postava tu není" ;
        } else if (aktualniProstor.obsahujePostavu("Bill") || aktualniProstor.obsahujePostavu("Jessica") ) {
            return postava.getProslov();
        }
        else if (aktualniProstor.obsahujePostavu("John")) {
            hra.setKonecHry(true);
            return postava.getProslov();

        } else if (aktualniProstor.obsahujePostavu("stráž")) {
            return "nemůžeš mluvit na stráž";

        }
        else {
            return "Nemám se koho zeptat.";
        }
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
