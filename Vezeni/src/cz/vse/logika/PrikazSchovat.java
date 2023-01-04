package cz.vse.logika;

/**
 *  Třída PrikazSchovat - slouží ke schování v nějakých místnostech.
 *
 *@author     Natálie Kuželová
 *@version    2022/2023
 */

public class PrikazSchovat implements IPrikaz {

    private static final String NAZEV = "schovat";

    private HerniPlan plan;
    private Hra hra;

    private Inventar inventar;


    public PrikazSchovat(HerniPlan plan, Hra hra, Inventar inventar) {
        this.plan = plan;
        this.hra = hra;
        this.inventar = inventar;
    }


    /**
     * Tato metoda pomáhá hráči se schovat.
     * @return zpráva, která je vypsaná hráči. Nebo chybná zpráva při zadání neznámého parametru.
     */


    public String provedPrikaz(String... parametry) {

        if (parametry.length == 0 && (plan.getAktualniProstor().getNazev().equals("sprchy"))) {
            hra.setKonecHry(true);
            return "Postava se snažila schovat před druhým vězněm.\nBohužel to nestihla a byla bodnuta do zad.\nPomalu umíráš a vykrvácíš na zem.";
        } else if (parametry.length == 0 && inventar.obsahujeVec("peníze") && (plan.getAktualniProstor().getNazev().equals("hlavníMístnostStráže"))) {
           hra.setKonecHry(true);
            return "Rychle ses schoval za stůl, bohužel tě už stráž viděla.\nNaštěstí máš u sebe peníze, takže se ti povedlo podplatit stráž a ta tě nechala utéct. Užívej svobodu. ";

        } else if (parametry.length == 0 && (plan.getAktualniProstor().getNazev().equals("hlavníMístnostStráže"))) {
            hra.setKonecHry(true);
            return "Bohužel stráž tě viděla jak se schováváš. Ihned tě odvedli na samotku.\n Odsud už se nedostaneš. Smutné";
        }  else if (parametry.length >= 1) {
            return "Prosím použijte příkaz bez dalších slov, děkuji.";
        } else {
          return  "Nemohu se zde schovat.";
        }
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }

}
