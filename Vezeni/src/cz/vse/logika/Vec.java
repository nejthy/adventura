package cz.vse.logika;

/**
 * Class Vec je na věci ve hře.
 * Obsahuje jméno věci a booleanovou hodnotu, jestli je věc sebratelná.
 *
 * @author Natálie Kuželová
 * @version školní rok 2022/23
 */

public class Vec {
    private final String nazev;
    private boolean sebratelna;

    /**
     * Konstruktor pro věci - vytváří věci.
     *
     * @param nazev      název věci
     * @param sebratelna jestli se dá věc dát do inventáře či ne
     */

    public Vec(String nazev, boolean sebratelna) {
        this.nazev = nazev;
        this.sebratelna = sebratelna;

    }

    public String getNazev() {
        return nazev;
    }
    public boolean isPrenositelna() {
        return sebratelna;
    }



    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if (!(o instanceof Vec)) {
            return false;
        }
        Vec druha = (Vec) o;

        return java.util.Objects.equals(this.nazev, druha.nazev);
    }

}
