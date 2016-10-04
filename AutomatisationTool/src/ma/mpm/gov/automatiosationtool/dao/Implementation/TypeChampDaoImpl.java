package ma.mpm.gov.automatiosationtool.dao.Implementation;

import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ma.mpm.gov.automatiosationtool.dao.Interface.TypeChampDao;
import ma.mpm.gov.automatiosationtool.model.TypeChamp;

@Repository
@Transactional
public class TypeChampDaoImpl implements TypeChampDao{
	  @Autowired
	    private SessionFactory factory;
 
	  public TypeChamp getById(int i ){
	        return (TypeChamp) factory.getCurrentSession().get(TypeChamp.class,i);
	    }
	   
	  
	     @SuppressWarnings("unchecked")
	      public List<TypeChamp> findAll(){
	            List<TypeChamp> theTypeChamps = factory.getCurrentSession().createQuery("from TypeChamp").list();
	            return theTypeChamps;
	            }        


	}
