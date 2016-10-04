package ma.mpm.gov.automatiosationtool.dao.Implementation;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ma.mpm.gov.automatiosationtool.dao.Interface.TestEtapeDao;
import ma.mpm.gov.automatiosationtool.model.TestEtape;


@Repository
@Transactional
public class TestEtapeDaoImpl implements TestEtapeDao{
        
    
  @Autowired
  private SessionFactory factory;
   
  public TestEtape getById(int i ){
      return (TestEtape) factory.getCurrentSession().get(TestEtape.class,i);
  }
  
  public void saveorupdate(TestEtape a)
   {
    factory.getCurrentSession().saveOrUpdate(a);
   }


   @SuppressWarnings("unchecked")
   public List<TestEtape> findAll(){
          List<TestEtape> theTestEtapes = factory.getCurrentSession().createQuery("from TestEtape").list();
          return theTestEtapes;
          }
   
   
   public void delete(TestEtape a)
   {
    factory.getCurrentSession().delete(a);
   }



}
