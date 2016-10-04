package ma.mpm.gov.automatiosationtool.dao.Implementation;

import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ma.mpm.gov.automatiosationtool.dao.Interface.ModuleDao;
import ma.mpm.gov.automatiosationtool.model.Module;

@Repository
@Transactional
public class ModuleDaoImpl implements ModuleDao{
	  
    @Autowired
    private SessionFactory factory;


	public Module getById(int i ){
        return (Module) factory.getCurrentSession().get(Module.class,i);
    }
    
     @SuppressWarnings("unchecked")
     public List<Module> findAll(){
            List<Module> theModules = factory.getCurrentSession().createQuery("from Module").list();
            return theModules;
            }        


}
