package ma.mpm.gov.automatiosationtool.gestion.Interface;

import java.util.List;

import ma.mpm.gov.automatiosationtool.model.TestEtape;



public interface GestionTestEtape {

	public TestEtape getById(int  i);
	public List<TestEtape> findAll();
	public void delete(TestEtape a);
	public void saveorupdate(TestEtape a);
	
}
