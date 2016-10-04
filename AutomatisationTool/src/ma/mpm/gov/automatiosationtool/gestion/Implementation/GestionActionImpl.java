package ma.mpm.gov.automatiosationtool.gestion.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.mpm.gov.automatiosationtool.dao.Interface.ActionDao;
import ma.mpm.gov.automatiosationtool.gestion.Interface.GestionAction;
import ma.mpm.gov.automatiosationtool.model.Action;



@Service
public class GestionActionImpl implements GestionAction{
    
    @Autowired
    ActionDao act;
    public GestionActionImpl(){
    	
    }
    public Action getById(int i ){
    	return act.getById(i);
    }
    
     public List<Action> findAll(){
    	 
        return act.findAll();
    }
    

  		 
 }             
