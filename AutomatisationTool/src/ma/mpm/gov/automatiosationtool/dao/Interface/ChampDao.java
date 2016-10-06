package ma.mpm.gov.automatiosationtool.dao.Interface;

import java.util.List;

import ma.mpm.gov.automatiosationtool.model.Champ;



public interface ChampDao {

	public Champ getById(int  i);
	public List<Champ> findAll(int i);
	public List<Champ> findAll();
	public void delete(Champ a);
	public boolean saveorupdate(Champ a);
	public List<Champ> findBy(String module,String etape,String menu,String texte);
	 public List<Champ> findBy(int i);
     public void increase(int i);


}
