package ma.mpm.gov.automatiosationtool.dao.Interface;

import java.util.List;



import ma.mpm.gov.automatiosationtool.model.TypeChamp;

public interface TypeChampDao {
	public TypeChamp getById(int i );
	public List<TypeChamp> findAll();
}
