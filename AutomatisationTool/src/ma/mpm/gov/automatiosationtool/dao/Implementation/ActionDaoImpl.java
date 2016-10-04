package ma.mpm.gov.automatiosationtool.dao.Implementation;

import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ma.mpm.gov.automatiosationtool.dao.Interface.ActionDao;
import ma.mpm.gov.automatiosationtool.model.Action;

@Repository
@Transactional
public class ActionDaoImpl implements ActionDao{
        
        @Autowired
        private SessionFactory factory;

        
        public Action getById(int i ){
             return (Action) factory.getCurrentSession().get(Action.class,i);
         }
         @SuppressWarnings("unchecked")
         public List<Action> findAll(){
                List<Action> theActions = factory.getCurrentSession().createQuery("from Action").list();
                return theActions;
                }        


}
