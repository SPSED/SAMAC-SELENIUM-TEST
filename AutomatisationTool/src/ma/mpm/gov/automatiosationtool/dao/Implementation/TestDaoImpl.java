package ma.mpm.gov.automatiosationtool.dao.Implementation;

import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ma.mpm.gov.automatiosationtool.dao.Interface.TestDao;
import ma.mpm.gov.automatiosationtool.model.Test;

@Repository
@Transactional
public class TestDaoImpl implements TestDao{
        
	 @Autowired
	    private SessionFactory factory;
	     
	    public Test getById(int i ){
	        return (Test) factory.getCurrentSession().get(Test.class,i);
	    }
	    
	    public void saveorupdate(Test a)
	     {
	      factory.getCurrentSession().saveOrUpdate(a);
	     }


	     @SuppressWarnings("unchecked")
	     public List<Test> findAll(){
	            List<Test> theTests = factory.getCurrentSession().createQuery("from Test").list();
	            return theTests;
	            }
	     
	     
	     public void delete(Test a)
	     {
	      factory.getCurrentSession().delete(a);
	     }

	}
