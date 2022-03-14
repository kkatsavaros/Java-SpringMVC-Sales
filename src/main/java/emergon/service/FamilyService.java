package emergon.service;

import emergon.entity.Family;
import emergon.repository.FamilyRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class FamilyService {
    
    @Autowired
    private FamilyRepo familyRepo;
    
    public List<Family> getFamilyBySalesman(int scode){
        
        //1. 
        // Δικιά μου ονομασία: findBySalesmanId
        List<Family> family = familyRepo.findBySalesmanId(scode);
        return family;
        
    }   
}
    
//    public List<Family> getFamilyBySalesman(int scode){
//        List<Family> family = familyRepo.findBySalesmanGetterList(scode);
//        return family;
//    }   
    

