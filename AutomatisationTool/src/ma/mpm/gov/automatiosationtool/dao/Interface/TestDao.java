package ma.mpm.gov.automatiosationtool.dao.Interface;

import java.util.List;



import ma.mpm.gov.automatiosationtool.model.Test;

public interface TestDao {
        
	
     public List<Test> findAll();
     public void delete(Test a);
     public Test getById(int i );
     public void saveorupdate(Test a);
	 public List<Test> findBy(String module, String etape, String test);
}
