package ma.mpm.gov.automatiosationtool.gestion.Interface;

import java.util.List;



import ma.mpm.gov.automatiosationtool.model.Test;

public interface GestionTest {
        
	
     public List<Test> findAll();
     public void delete(Test a);
	 public void saveorupdate(Test a);
	 public Test getById(int i);
	    
}
