package dao;

import org.springframework.stereotype.Component;

@Component("dao2") // a chaque fois spring trouve une class a commancer par component il va l instancie
public class DaoImpl implements IDao {
    @Override
    public double getData() {
        /*
        se connecter a la BD pour recuperre la temperature
         */
        System.out.println("version base de donnee");
        double temp= Math.random()*40;
        return temp;
    }
}
