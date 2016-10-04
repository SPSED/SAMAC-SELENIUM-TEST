package ma.mpm.gov.automatiosationtool.dao.Interface;

import java.util.List;



import ma.mpm.gov.automatiosationtool.model.Module;

public interface ModuleDao {
        
	 public Module getById(int i );
     public List<Module> findAll();


}
