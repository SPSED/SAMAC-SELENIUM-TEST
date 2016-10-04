package ma.mpm.gov.automatiosationtool.gestion.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.mpm.gov.automatiosationtool.dao.Interface.MenuDao;
import ma.mpm.gov.automatiosationtool.gestion.Interface.GestionMenu;
import ma.mpm.gov.automatiosationtool.model.Menu;



@Service
public class GestionMenuImpl implements GestionMenu{
    
    @Autowired
    MenuDao act;
    public GestionMenuImpl(){
    	
    }
    public Menu getById(int i ){
    	return act.getById(i);
    }
     public List<Menu> findAll(int i){
        return act.findAll(i);
    }		 
 }             
