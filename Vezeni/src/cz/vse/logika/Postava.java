package cz.vse.logika;


/**
 *  Třída Postava - určuje jméno postavy s kterou může hráč mluvit a taky fráze co postava řekne
 *  když na ni začne postava mluvit
 *@author     Natálie Kuželová
 *@version    ZS 2022/2023
 */

public class Postava {


  private String jmeno;
  private String proslov;



    /**
     * Konstruktor třídy Postava
     *
     * @param jmeno (jméno postavy)
     * @param proslov
     */
    public Postava(String jmeno, String proslov) {
        this.jmeno = jmeno;
        this.proslov = proslov;
    }



    /**
     * Metoda, která vrací jméno postav ve hře
     *
     * @return jmeno postavy
     */
    public String getJmenoPostava() {
        return jmeno; }

    public String getProslov(){
        return proslov;
    }

    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if (!(o instanceof Postava)) {
            return false;
        }
        Postava druha = (Postava) o;

        return java.util.Objects.equals(this.jmeno, druha.jmeno);
    }


}
