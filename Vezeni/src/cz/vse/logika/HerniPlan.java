package cz.vse.logika;


/**
 *  Class HerniPlan - třída představující mapu a stav adventury.
 *
 *  Tato třída inicializuje prvky ze kterých se hra skládá:
 *  vytváří všechny prostory,
 *  propojuje je vzájemně pomocí východů
 *  a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *
 *@author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova, Natálie Kuželová
 *@version    ZS 2022/2023
 */

public class HerniPlan {

    private Prostor aktualniProstor;
    private Prostor venekProstor;


    /**
     *  Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví celu.
     */
    public HerniPlan() {
        zalozProstoryHry();
    }

    /**
     *  Vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví cela.
     */

    private void zalozProstoryHry() {
        // vytvářejí se jednotlivé prostory
        Prostor cela = new Prostor("cela","cela, odsud můžeš jít jenom na chodbu");
        Prostor sprchy = new Prostor("sprchy", "sprchy.\nVe sprchách vidíš jednoho z tvých nepřátel zdřívějších dob.\nMůžeš rychle odejít, aniž by si tě všiml, schovat se nebo můžeš proti němu vyběhnout a zaútočit.");
        Prostor chodba = new Prostor("chodba","chodba.");
        Prostor hriste = new Prostor("hřiště","Přišel si na hřistě.\nZde vidíš jak všichni hrajou fotbal.\nV dálce vidíš svého kamaráda Billa\nMůžeš jít pokecat nebo se otočit a jít zpět.\nPřece co si budem, Bill nezavře pusu a je někdy až moc otravný");
        Prostor venek = new Prostor("venek","Výborně, jsi na svobodě");
        Prostor hlavniMistnostStraze = new Prostor("hlavníMístnostStráže","hlavníMístnostStráže. Přisel si do místnosti strážců.\nZatím si tě nikdo nevšiml, ale není to na dlouho.\nBohužel už se odsud vrátit nemůžeš, to by tě viděli.\n" +
                "Ale máš další možnosti. První je prostě zkusit projít ke dveřím, schovat se nebo zaútočit na stráž.");
        Prostor jidelna = new Prostor("jídelna","jídelna. Všude plno nepřátel. Pár kamarádů. Moc dlouho bych se nezdržovala.\n");
        Prostor klubovna = new Prostor("klubovna", "klubovna. V rohu vidíš jak stojí nějáká typka. Jinak jen samé knihy.");


        Vec kladivo = new Vec("kladivo",true);
        Vec kancelarskaSpona = new Vec("kancelářskáSpona",true);
        Vec zidle = new Vec("židle",false);
        Vec sroubovak = new Vec("šroubovák",true);
        Vec sud =  new Vec("sud", false);



        Postava Bill = new Postava("Bill", "Čau kámo, long time no see. Jak si mi řikal minule o tom, že bys chtěl utéct.\nPss neboj já to nikomu neřeknu, jen mě tak napadlo že by se ti hodilo vědět, co jsem se dozvěděl.\nNěkdo řikal, že je dobrý mít nějakou věc na otevření dveří ven.\nTak by se ti to mohlo třeba hodit kdo ví...");
        Postava John = new Postava("John", "To nebyl dobrý nápad se ptát. Hned si tě john všiml a zabodnul svým nožem. Smutné.");
        Postava straz = new Postava("stráž", "nemám frázi");
        Postava Jessica = new Postava("Jessica", "Být tebou, tak si jdu zahrát fotbal na hřiště. Stačí tam dojít a napsat zahraj.");


/**
 *  Věci v místnostech
 */

        hriste.setVec(kladivo);
        hriste.setVec(sud);
        klubovna.setVec(kancelarskaSpona);
        chodba.setVec(zidle);
        cela.setVec(sroubovak);


        /**
         *  Postavy v místnostech
         */
        hriste.vlozPostavu(Bill);
        sprchy.vlozPostavu(John);
        hlavniMistnostStraze.vlozPostavu(straz);
        klubovna.vlozPostavu(Jessica);
/**
 *  Východy
 */


        cela.setVychod(chodba);
        chodba.setVychod(cela);
        chodba.setVychod(hriste);
        chodba.setVychod(jidelna);
        chodba.setVychod(sprchy);
        hriste.setVychod(chodba);
        jidelna.setVychod(chodba);
        sprchy.setVychod(chodba);
        jidelna.setVychod(hlavniMistnostStraze);
        hlavniMistnostStraze.setVychod(venek);
        klubovna.setVychod(jidelna);
        jidelna.setVychod(klubovna);

        aktualniProstor = cela;  // hra začíná v cele
        venekProstor = venek; // venku se hra ukončí
    }

    /**
     *  Metoda vrací odkaz na aktuální prostor, ve ktetém se hráč právě nachází.
     *
     *@return     aktuální prostor
     */

    public Prostor getAktualniProstor() {
        return aktualniProstor;
    }



    /**
     *  Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory
     *
     *@param cela nový aktuální prostor
     */
    public void setAktualniProstor(Prostor cela) {
        aktualniProstor = cela;
    }
    /**
     * Metoda kontroluje jestli se postava dostala do prostoru 'venek'.
     * V tomto případě se v class Hra v metodě zpracujPrikaz (input z terminálu) vypíše příslušný text a ukončí hra.
     *
     * @return true pokud je postava u venku
     */
    public boolean jeVenku() {
        return aktualniProstor.equals(venekProstor);
    }
}
