package emergon.repository;

import emergon.entity.Salesman;
import java.util.List;
import org.springframework.stereotype.Repository;


@Repository
public class SalesmanRepo extends HibernateUtil<Salesman> implements CrudRepo<Salesman>{

    @Override
    public Salesman save(Salesman s) {
        return super.save(s);
    }

    @Override
    public void delete(int id) {
        super.delete(Salesman.class, id);
    }

    @Override
    public Salesman findById(int id) {
        return super.find(Salesman.class, id);
    }

    @Override
    public List<Salesman> findAll() {
        return super.findAll("Salesman.findAll");
    }
    
}
