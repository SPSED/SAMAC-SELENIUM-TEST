package ma.mpm.gov.automatiosationtool.gestion.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.mpm.gov.automatiosationtool.dao.Interface.ChampDao;
import ma.mpm.gov.automatiosationtool.gestion.Interface.GestionChamp;
import ma.mpm.gov.automatiosationtool.model.Champ;



@Service
public class GestionChampImpl implements GestionChamp{
    
    @Autowired
    ChampDao act;
    public GestionChampImpl(){
    	
    }
    
    public Champ getById(int i){
        return act.getById(i);
    }
    
    public boolean saveorupdate(Champ a){
        return act.saveorupdate(a);
    }
    
     public List<Champ> findAll(int i){
        return act.findAll(i);
    }
    
     public List<Champ> findAll(){
         return act.findAll();
     }
     
     public void delete(Champ a){
        act.delete(a);
    }
	 public List<Champ> findBy(String module,String etape,String menu,String libelle){
    	 return act.findBy(module, etape, menu, libelle);
     }
     
	 public List<Champ> findBy(int i){
		 return act.findBy(i);
	 }
     public void increase(int i){
    	 act.increase(i);
     }

  		 
 }             
