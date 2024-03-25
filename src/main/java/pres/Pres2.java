package pres;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

  //  anstanciation dynamique c est le bon chose pour une app
// ferme a la modification et ouverte a l extension
// on doit ecrirre une fichier  de CONFIG.Txt


public class Pres2 {
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Scanner scanner = new Scanner(new File("config.txt"));
        String daoClassName = scanner.nextLine(); // lire le premier ligne de texte  Le nom de la class.
        Class cDao = Class.forName(daoClassName);// tout les class charge au memoir sous form d un objet de type Class
      IDao dao =(IDao) cDao.newInstance(); //  il faut instance la class comme new

        String metierClassName = scanner.nextLine(); //
        Class cMetier = Class.forName(metierClassName);
        IMetier metier =(IMetier) cMetier.newInstance();

        Method method = cMetier.getMethod("setDao",IDao.class);
        //metier.setDao(dao);
        method.invoke(metier,dao); // ivokee la methode SetDao sur l objet Metier en parametrre dao .

        System.out.println("resultat=>"+metier.calcul()); // l injection des depandence de manier dynamaique

    }
}
