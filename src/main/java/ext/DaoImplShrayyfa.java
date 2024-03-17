package ext;

import dao.IDao;

public class DaoImplShrayyfa implements IDao {
    @Override
    public double getData() {
        System.out.println("version shrayyfa");
        return 322;
    }
}
