package emergon.repository;

import emergon.entity.Family;
import emergon.entity.Salesman;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class FamilyRepo extends HibernateUtil<Family> implements CrudRepo<Family>{

    @Autowired
    private SalesmanRepo salesmanRepo;    
    
    //---------------------------------------------------------------------------------------------
    //  Αυτά είναι ίδια με το SalesmanRepo.
    //---------------------------------------------------------------------------------------------
    @Override
    public Family save(Family s) {
        return super.save(s);
    }

    @Override
    public void delete(int id) {
        super.delete(Family.class, id);
    }

    @Override
    public Family findById(int id) {
        return super.find(Family.class, id);
    }

    @Override
    public List<Family> findAll() {
        return super.findAll("Family.findAll");
    }
    //---------------------------------------------------------------------------------------------
    
    //1.
    //---------------------------------------------------------------------------------------------
    public List<Family> findBySalesmanId(int scode) {
        
        Session session = getSession();
        
        // Πρέπει να πάω στην Family class και να φτιάξω αυτό το query.
        Query<Family> query = session.createNamedQuery("Family.findBySalesman", Family.class);
        query.setParameter("scode", scode);
        List<Family> family = query.getResultList();
        return family;
        
    }
    //---------------------------------------------------------------------------------------------
    
//    //2.
//    //---------------------------------------------------------------------------------------------
//    public List<Family> findBySalesman(int scode) {
//        
//        Session session = getSession();
//        Salesman salesman = salesmanRepo.findById(scode);
//        Query<Family> query = session.createNamedQuery("Family.findBySalesman", Family.class);
//        query.setParameter("salesman", salesman);
//        List<Family> family = query.getResultList();
//        return family;
//        
//    }
//    //---------------------------------------------------------------------------------------------
//    
//    
//    //---------------------------------------------------------------------------------------------
//    public List<Family> findBySalesmanGetterList(int scode) {
//        
//        Session session = getSession();
//        Salesman salesman = salesmanRepo.findById(scode);
//        salesman = (Salesman) session.merge(salesman);
//        int sizeOfFamily = salesman.getFamilyList().size();
//        List<Family> family = salesman.getFamilyList();
//        return family;
//    }
//    //---------------------------------------------------------------------------------------------
//    
}
