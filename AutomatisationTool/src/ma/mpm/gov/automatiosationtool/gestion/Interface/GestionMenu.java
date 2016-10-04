package ma.mpm.gov.automatiosationtool.gestion.Interface;

import java.util.List;



import ma.mpm.gov.automatiosationtool.model.Menu;

public interface GestionMenu {
        
	 public Menu getById(int i );
     public List<Menu> findAll(int i);


}
