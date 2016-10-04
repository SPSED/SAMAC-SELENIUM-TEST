package ma.mpm.gov.automatiosationtool.dao.Interface;

import java.util.List;



import ma.mpm.gov.automatiosationtool.model.Menu;

public interface MenuDao {
        
	 public Menu getById(int i );
     public List<Menu> findAll(int i);


}
