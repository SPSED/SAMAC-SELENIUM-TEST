package ma.mpm.gov.automatiosationtool.gestion.Interface;

import java.util.List;



import ma.mpm.gov.automatiosationtool.model.Etape;

public interface GestionEtape {
        
	 public Etape getById(int i );
     public List<Etape> findAll(int i);


}
