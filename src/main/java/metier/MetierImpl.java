package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("metier")
public class MetierImpl implements IMetier { //implementation de cette interface
    // la classe MetierImpl qui depends de la couch Dao



    //couplage faible
    @Autowired
    @Qualifier ("dao") // inject moi  l instance qui s appel dao
    // plusier instance  qui implement la meme interface et apres vous specifie la qelle instance pour injecter




    //pour fait l injection des des depndnc
    private IDao dao;

    public MetierImpl(IDao dao) {
        this.dao = dao; // l injection hia l constructeur ou setter ou autweird
    }

    // dao variable n est pas inisialise et encore ca c est une indepandence
    // pour ne pas dependre de la classe on dependre de l interface
    // depende des interface et ne depands pas des classe
    @Override
    public double calcul() { //la couche metier dans la methode calcul
        double tmp=dao.getData();
        double res=tmp*540/Math.cos(tmp*Math.PI); //pour fait le calcule ona besoin de la methode getdata de la couche Dao;
        return res;
    }

     /*
    alors SetDao c est une methode qui va me permettre d affecter une valeur a Dao
    injecter dans la variable dao un objet  d une class qui implemente l interface IDao
      */
    public void setDao(IDao dao) { // one fait Set pour injecter  de dependence qua la variable il est nul
        //dao= null on ai fait l injection des dependence
               this.dao = dao;
    }
 }
