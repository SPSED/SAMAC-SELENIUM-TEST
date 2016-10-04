package ma.mpm.gov.automatiosationtool.dao.Implementation;

import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ma.mpm.gov.automatiosationtool.dao.Interface.EtapeDao;
import ma.mpm.gov.automatiosationtool.model.Etape;

@Repository
@Transactional
public class EtapeDaoImpl implements EtapeDao{
        
        @Autowired
        private SessionFactory factory;
         
        public Etape getById(int i ){
            return (Etape) factory.getCurrentSession().get(Etape.class,i);
        }
        
         @SuppressWarnings("unchecked")
         public List<Etape> findAll(int i){
                List<Etape> theEtapes = factory.getCurrentSession().createQuery("from Etape E where E.module.idModule=:var").setParameter("var",i).list();
                return theEtapes;
               							  }
         
}
