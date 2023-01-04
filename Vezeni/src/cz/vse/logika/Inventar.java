package cz.vse.logika;

import java.util.HashMap;
import java.util.Map;

/**
 * Pomocí třídy Inventar může hráč sbírat věci do inventář.
 * Funkcionalita je zajištěna pomocí mapy s věcmi, která obsahuje to co má u sebe hráč. Hráč může u sebe mít jenom
 * omezený počet věcí, který je nastavený v atributu "velikost" - v tomhle případě může nosit maximálně 2 věci u sebe.
 * Pokus o přidání 3. věci se nepodaří.
 *
 * @author Natálie Kuželová
 * @version ZS 2022/23
 */

public class Inventar {
    public Map<String, Vec> veci;
    private static final int velikost = 2;


    private Vec vec;

    /**
     * Konstruktor, který vytváří inventář
     * @param vec
     */

    public Inventar(Vec vec) {
        veci = new HashMap<>(); this.vec = vec; }

    /**
     * Metoda sloužící k přidávání věcí do inventáře pokud se tam vejdou a
     * pokud jsou přenositelné
     */
    public boolean vlozVec(Vec vec) {
        if (inventarJePlny() && vec.isPrenositelna()){
            veci.put(vec.getNazev(), vec);
            return true;
        }
        return false;
    }



    /**
     * Metoda sloužící k odebrání věcí.
     * @param nazevVeci (název věci)
     * @return
     */
    public boolean odeberVec(String nazevVeci) {
        if (!inventarJePrazdny()){
            veci.remove(nazevVeci);
            return true;
        }
        return false;
    }



    /**
     * Metoda která ukazuje jaké věci se nacházejí v inventáři
     * @return veci (což je mapa věcí, které jsou v inventáři)
     */
    public String obsahInventare() {
        String obsahInv = "Předměty v inventáři: ";
        for (String nazev : veci.keySet()) {
            obsahInv += nazev + ", ";
        }
        return obsahInv;
    }


    /**
     * Metoda která získává věc, kterou hráč zadá
     *
     * @param nazev (název věci)
     * @return veci (což je název hledané věci)
     */

    public Vec getVec(String nazev) {
        return veci.get(nazev);
    }

    /**
     * Metoda, která vrací, zda daná věc je obsažena v inventáři (slouží také k otestování třídy Inventar ve třídě InventarTest)
     *
     * @param nazev (název věci)
     * @return veci (název věci)
     */
    public boolean obsahujeVec(String nazev) {
        return veci.containsKey(nazev);
    }



    /**
     * Metoda, která vrací celkovou velikost inventáře.
     *
     * @return veliostInv
     */

    public int getVelikostInv() {
        return velikost;
    }

    /**
     * Metoda, která ověřuje, kdy je inventář plný
     *
     * @return veci.size() < velikostInv (vrací informaci, zda je inventář plný nebo ne.)
     */

    public boolean inventarJePlny() {
        return veci.size() < velikost;
    }

    public boolean inventarJePrazdny() {
        return veci.size() == 0;
    }


}
