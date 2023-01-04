package cz.vse.logika;


    /**
     *  Třída PrikazInventar - slouží k vypsání obsahu inventáře.
     *
     *@author     Natálie Kuželová
     *@version    2022/2023
     */

    public class PrikazInventar implements IPrikaz {

        private static final String NAZEV = "inventář";
        private Inventar inventar;

        /**
         * Konstruktor třídy PrikazInventar
         *
         * @param inventar (inventář ve kterém se nachází sebrané věci)
         */
        public PrikazInventar (Inventar inventar) {
            this.inventar = inventar;
        }

        /**
         * Provádí příkaz "inventář". Do Inventář sbírá hráč věci, pokud jdou sebrat
         *
         * @param parametry (jaka parametr obsahuje název věci)
         * @return zpráva, která je vypsaná do textového řádku při zadání příkazu "inventář")
         */
        @Override
        public String provedPrikaz(String... parametry) {
            return "Velikost inventáře: "  + inventar.getVelikostInv() + "\n" + inventar.obsahInventare();
        }

        /**
         *  Metoda vrací název příkazu (resp. slovo, které hráč napíše do textového řádku pro vyvovlání příkazu.)
         *
         * @return NAZEV (název příkazu)
         */
        @Override
        public String getNazev() {
            return NAZEV;
        }
    }


