package ma.mpm.gov.automatiosationtool.dao.Implementation;

import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ma.mpm.gov.automatiosationtool.dao.Interface.MenuDao;
import ma.mpm.gov.automatiosationtool.model.Menu;

@Repository
@Transactional

public class MenuDaoImpl implements MenuDao{
   

	   @Autowired
    private SessionFactory factory;

	   public Menu getById(int i ){
	        return (Menu) factory.getCurrentSession().get(Menu.class,i);
	    }
	   
	   @SuppressWarnings("unchecked")
     public List<Menu> findAll(int i){
            List<Menu> theMenus = factory.getCurrentSession().createQuery("from Menu m where m.etape.numEtape=:var").setParameter("var",i).list();
            return theMenus;
            }        


}
 



