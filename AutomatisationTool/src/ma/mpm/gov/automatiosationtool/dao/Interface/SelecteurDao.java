package ma.mpm.gov.automatiosationtool.dao.Interface;

import java.util.List;



import ma.mpm.gov.automatiosationtool.model.Selecteur;

public interface SelecteurDao {
        
	 public Selecteur getById(int i );
     public List<Selecteur> findAll();


}
