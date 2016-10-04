package ma.mpm.gov.automatiosationtool.dao.Interface;

import java.util.List;



import ma.mpm.gov.automatiosationtool.model.Etape;

public interface EtapeDao {
        
	 public Etape getById(int i );
     public List<Etape> findAll(int i);


}
