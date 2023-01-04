package cz.vse.logika;

/**
 *  Třída PrikazJdi - slouží k procházení hry.
 *
 *@author     Natálie Kuželová
 *@version    2022/2023
 */


public class PrikazJdi implements IPrikaz{
    private static final String NAZEV = "jdi";
    private HerniPlan herniPlan;
    private final Hra hra;
    private final Inventar inventar;
    private final Vec vec;



    /**
     * Konstruktor třídy
     *
     * @param herniPlan herní plán, ve kterém se bude ve hře "chodit"
     * @param inventar
     * @param vec
     */
    public PrikazJdi(HerniPlan herniPlan, Hra hra, Inventar inventar, Vec vec) {
        this.herniPlan = herniPlan;
        this.hra = hra;
        this.inventar = inventar;
        this.vec = vec;
    }

    /**
     *  Provádí příkaz "jdi". Zkouší se vyjít do zadaného prostoru. Pokud prostor
     *  existuje, vstoupí se do nového prostoru. Pokud zadaný sousední prostor
     *  (východ) není, vypíše se chybové hlášení.
     *
     *@param parametry - jako  parametr obsahuje jméno prostoru (východu),
     *                         do kterého se má jít.
     *@return zpráva, kterou vypíše hra hráči
     */
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            return "Kam mám jít? Musíš zadat jméno východu";
        }

        String smer = parametry[0];
        Prostor sousedniProstor = herniPlan.getAktualniProstor().vratSousedniProstor(smer);

        if (sousedniProstor == null) {
            return "Tam se odsud jít nedá!";
        } else if (herniPlan.getAktualniProstor().getNazev().equals("hlavníMístnostStráže") && !inventar.obsahujeVec("kancelářskáSpona"))
        { hra.setKonecHry(true);
            return "Bohužel dveře jsou zamčené a stráže tě viděli. Ihned tě odvedli na samotku. Odsud už se nedostaneš. Smutný konec.";
        }
            herniPlan.setAktualniProstor(sousedniProstor);
        return sousedniProstor.dlouhyPopis();
    }

    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *
     *  @ return nazev prikazu
     */

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
