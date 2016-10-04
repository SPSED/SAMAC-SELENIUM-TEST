package ma.mpm.gov.automatiosationtool.dao.Implementation;

import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ma.mpm.gov.automatiosationtool.dao.Interface.SelecteurDao;
import ma.mpm.gov.automatiosationtool.model.Selecteur;

@Repository
@Transactional
public class SelecteurDaoImpl implements SelecteurDao{
	  @Autowired
	    private SessionFactory factory;
      
	  public Selecteur getById(int i ){
	        return (Selecteur) factory.getCurrentSession().get(Selecteur.class,i);
	    }
	  
	     @SuppressWarnings("unchecked")
	     public List<Selecteur> findAll(){
	            List<Selecteur> theSelecteurs = factory.getCurrentSession().createQuery("from Selecteur").list();
	            return theSelecteurs;
	            }        


	}
