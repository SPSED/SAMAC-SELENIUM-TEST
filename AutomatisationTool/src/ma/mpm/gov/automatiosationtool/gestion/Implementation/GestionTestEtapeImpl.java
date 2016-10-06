package ma.mpm.gov.automatiosationtool.gestion.Implementation;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.mpm.gov.automatiosationtool.dao.Interface.TestEtapeDao;
import ma.mpm.gov.automatiosationtool.gestion.Interface.GestionTestEtape;
import ma.mpm.gov.automatiosationtool.model.Test;
import ma.mpm.gov.automatiosationtool.model.TestEtape;

@Service
public class GestionTestEtapeImpl implements GestionTestEtape{
    
    @Autowired
    TestEtapeDao act;
    
    public TestEtape getById(int i ){
        return act.getById(i);
    }
    
    public void saveorupdate(TestEtape a){  
        act.saveorupdate(a);
    }
    
     public List<TestEtape> findAll(){
        return act.findAll();
    }
    
     public void delete(TestEtape a){
        act.delete(a);
    }
     public GestionTestEtapeImpl(){
     	
     }
     public TestEtape getBy(Test t){
     return act.getBy(t);
     }
}

   