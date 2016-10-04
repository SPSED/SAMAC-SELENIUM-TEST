package ma.mpm.gov.automatiosationtool.gestion.Interface;

import java.util.List;

import ma.mpm.gov.automatiosationtool.model.Module;




public interface GestionModule {
        
	 public Module getById(int i );
     public List<Module> findAll();


}
