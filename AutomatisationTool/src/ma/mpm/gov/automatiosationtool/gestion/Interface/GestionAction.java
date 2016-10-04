package ma.mpm.gov.automatiosationtool.gestion.Interface;

import java.util.List;



import ma.mpm.gov.automatiosationtool.model.Action;

public interface GestionAction{
        
	public Action getById(int i );
     public List<Action> findAll();


}
