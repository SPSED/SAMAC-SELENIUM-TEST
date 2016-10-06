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
	     
		/* public List<Test> findBy(String module, String etape, String test){
			 StringBuilder query = new StringBuilder("select Test t join TestEtape e where t=e.test and 1=1");

			 if (test != null && !test.isEmpty()) {
					query.append(" and t.nomTest ='" + test + "'");
				}
			 
			 if (etape != null) { 
					query.append(" and e.etape.nomEtape ='" + etape + "'");
				}

				else if (module != null) {
					query.append(" and e.etape.module.nomModule ='" + module + "'");
				}
	
				query.append(" order by idTest");
				@SuppressWarnings("unchecked")
				List<Test> result = factory.getCurrentSession().createQuery(query.toString()).list();

				return result;
		 }*/
			public List<Test> findBy(String module, String etape, String test){
				 StringBuilder query = new StringBuilder("from TestEtape e inner join e.test where 1=1");

				 if (test != null && !test.isEmpty()) {
						query.append(" and e.test.nomTest ='" + test + "'");
					}
				 
				 if (etape != null) { 
						query.append(" and e.etape.nomEtape ='" + etape + "'");
					}

					else if (module != null) {
						query.append(" and e.etape.module.nomModule ='" + module + "'");
					}
		
					query.append(" order by e.test.idTest");
					
					@SuppressWarnings("unchecked")
					List<Test> result = (List<Test>)factory.getCurrentSession().createQuery(query.toString()).list();

					return result;
			 }

	     public void delete(Test a)
	     {
	      factory.getCurrentSession().delete(a);
	     }

	}
