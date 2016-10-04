package ma.mpm.gov.automatiosationtool.gestion.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.mpm.gov.automatiosationtool.dao.Interface.TypeChampDao;
import ma.mpm.gov.automatiosationtool.gestion.Interface.GestionTypeChamp;
import ma.mpm.gov.automatiosationtool.model.TypeChamp;



@Service
@Transactional
public class GestionTypeChampImpl implements GestionTypeChamp{
    
    @Autowired
    TypeChampDao act;
    public GestionTypeChampImpl(){
    	
    }
    
    public TypeChamp getById(int i ){
    	return act.getById(i);
    }
    
    public List<TypeChamp> findAll(){
        return act.findAll();
    }
    

  		 
 }             
