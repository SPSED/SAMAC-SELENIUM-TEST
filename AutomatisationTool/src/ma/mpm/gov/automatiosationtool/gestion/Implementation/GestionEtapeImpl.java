package ma.mpm.gov.automatiosationtool.gestion.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.mpm.gov.automatiosationtool.dao.Interface.EtapeDao;
import ma.mpm.gov.automatiosationtool.gestion.Interface.GestionEtape;
import ma.mpm.gov.automatiosationtool.model.Etape;

@Service
public class GestionEtapeImpl implements GestionEtape{
    
    @Autowired
    EtapeDao act;
    public GestionEtapeImpl(){
    	
    }
     
    public Etape getById(int i ){
    	return act.getById(i);
    }  
     public List<Etape> findAll(int i){
        return act.findAll(i);
    }		 
 }             
