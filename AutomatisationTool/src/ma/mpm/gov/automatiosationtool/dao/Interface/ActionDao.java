package ma.mpm.gov.automatiosationtool.dao.Interface;

import java.util.List;



import ma.mpm.gov.automatiosationtool.model.Action;

public interface ActionDao {
        
	public Action getById(int i );
     public List<Action> findAll();


}
