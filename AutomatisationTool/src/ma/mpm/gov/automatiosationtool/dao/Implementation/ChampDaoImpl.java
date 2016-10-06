package ma.mpm.gov.automatiosationtool.dao.Implementation;

import java.util.List;

import ma.mpm.gov.automatiosationtool.dao.Interface.ChampDao;
import ma.mpm.gov.automatiosationtool.model.Champ;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
@Transactional
public class ChampDaoImpl implements ChampDao {
		
	@Autowired
	private SessionFactory factory;
	 
	
	public Champ getById(int i ){
        return (Champ) factory.getCurrentSession().get(Champ.class,i);
    }
	

	 @SuppressWarnings("unchecked")
	 public List<Champ> findAll(int i){
		 String hql = "from Champ c WHERE c.etape.numEtape<=:num";
		 List<Champ> lesChamps = ( factory.getCurrentSession().createQuery(hql)
		 .setParameter("num", i)).list();
		 
			return lesChamps;
			}
     @SuppressWarnings("unchecked")
	public List<Champ> findBy(int i){
         List<Champ> lesChamps = factory.getCurrentSession().createQuery("from Champ c where c.menu.idMenu=:var").setParameter("var",i).list();
         return lesChamps;
        							  }
     
     public void increase(int i){
   
   Query query=factory.getCurrentSession().createQuery("UPDATE Champ c set c.idChamp=c.idChamp+1 WHERE c.idChamp>= :var ORDER BY c.idChamp DESC");
     query.setParameter("var",i+1).list();   		
     int result=query.executeUpdate();
     System.out.println(result);
     							}
     
	 @SuppressWarnings("unchecked")
	 public List<Champ> findAll(){
		 String hql = "from Champ";
		 List<Champ> lesChamps = factory.getCurrentSession().createQuery(hql).list();
		
			return lesChamps;
			}
	 
	 @SuppressWarnings("unchecked")
	 public List<Champ> findBy(String module,String etape,String menu,String texte){
		
		StringBuilder query = new StringBuilder("from Champ c where 1=1");

		if (texte != null && !texte.isEmpty()) {
			query.append(" and c.libelle ='" + texte + "'");
		}
		if (menu != null) {

			query.append(" and c.menu.nomMenu ='" + menu + "'");
		}
		else if (etape != null) {
			query.append(" and c.etape.nomEtape ='" + etape + "'");
		}

		else if (module != null) {
			query.append(" and c.etape.module.nomModule ='" + module + "'");
		}

		query.append(" order by idChamp");
		List<Champ> result = factory.getCurrentSession().createQuery(query.toString()).list();

		return result;
			}
	 
	 
	 public void delete(Champ a)
	 {
	  factory.getCurrentSession().delete(a);
	 }
	 
	 public boolean saveorupdate(Champ a) {
		  boolean success = false;   
		  try {
			  factory.getCurrentSession().saveOrUpdate(a);			  
			  success = true;
		  } catch (Exception e) {
		   
		  } 
		  return success ;
		}
	
	 
	 


}
