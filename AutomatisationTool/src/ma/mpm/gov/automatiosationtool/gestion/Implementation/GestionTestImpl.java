package ma.mpm.gov.automatiosationtool.gestion.Implementation;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.mpm.gov.automatiosationtool.dao.Interface.TestDao;
import ma.mpm.gov.automatiosationtool.gestion.Interface.GestionTest;
import ma.mpm.gov.automatiosationtool.model.Test;

@Service
public class GestionTestImpl implements GestionTest{
    
    @Autowired
    TestDao act;
    
    public Test getById(int i){
        return act.getById(i);
    }
    
    public void saveorupdate(Test a){  
        act.saveorupdate(a);
    }
    
     public List<Test> findAll(){
        return act.findAll();
    }
    
     public void delete(Test a){
        act.delete(a);
    }
     public GestionTestImpl(){
     	
     }
}

