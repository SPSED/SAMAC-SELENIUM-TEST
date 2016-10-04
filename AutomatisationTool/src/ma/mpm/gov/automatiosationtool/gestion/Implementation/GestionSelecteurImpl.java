package ma.mpm.gov.automatiosationtool.gestion.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.mpm.gov.automatiosationtool.dao.Interface.SelecteurDao;
import ma.mpm.gov.automatiosationtool.gestion.Interface.GestionSelecteur;
import ma.mpm.gov.automatiosationtool.model.Selecteur;


@Service

public class GestionSelecteurImpl implements GestionSelecteur{
    
    @Autowired
    SelecteurDao act;
    public GestionSelecteurImpl(){
    	
    }
    
    public Selecteur getById(int i ){
    	return act.getById(i);
    }
    
     public List<Selecteur> findAll(){
        return act.findAll();
    }
    

  		 
 }             
