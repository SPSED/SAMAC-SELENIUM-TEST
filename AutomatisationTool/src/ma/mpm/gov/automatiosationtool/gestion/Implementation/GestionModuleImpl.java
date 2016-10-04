package ma.mpm.gov.automatiosationtool.gestion.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.mpm.gov.automatiosationtool.dao.Interface.ModuleDao;
import ma.mpm.gov.automatiosationtool.gestion.Interface.GestionModule;
import ma.mpm.gov.automatiosationtool.model.Module;



@Service
public class GestionModuleImpl implements GestionModule{
    
    @Autowired
    ModuleDao act;
    public GestionModuleImpl(){
        
    }
    
    public Module getById(int i ){
    	return act.getById(i);
    }
    
     public List<Module> findAll(){
        return act.findAll();
    }
    

         
 }             
