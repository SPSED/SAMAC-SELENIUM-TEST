package ma.mpm.gov.automatiosationtool.dao.Interface;

import java.util.List;

import ma.mpm.gov.automatiosationtool.model.Test;
import ma.mpm.gov.automatiosationtool.model.TestEtape;



public interface TestEtapeDao {

	public TestEtape getById(int  i);
	public List<TestEtape> findAll();
	public void delete(TestEtape a);
	public void saveorupdate(TestEtape a);
	   public TestEtape getBy(Test t);
}
