package pres;

import ext.DaoImpl2;
import metier.MetierImpl;

public class Presentation {
    public static void main(String[] args) {
         /*
          // et pour fait l injection de dependence dans nous avons
          commencer par l anstanciation  static avec new

         Injection des dependances par
         instanciation statique  ==> new = couplage fort
          */
         // anstanciation Statique.
        DaoImpl2 dao =new DaoImpl2();
        MetierImpl metier=new MetierImpl(dao);
        metier.setDao(dao); // l'injection
        System.out.println("Resultat="+metier.calcul());

    }
}
