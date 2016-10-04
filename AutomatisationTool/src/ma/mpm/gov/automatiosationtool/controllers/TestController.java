package ma.mpm.gov.automatiosationtool.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ma.mpm.gov.automatiosationtool.gestion.Interface.GestionEtape;
import ma.mpm.gov.automatiosationtool.gestion.Interface.GestionModule;
import ma.mpm.gov.automatiosationtool.gestion.Interface.GestionTest;
import ma.mpm.gov.automatiosationtool.gestion.Interface.GestionTestEtape;
import ma.mpm.gov.automatiosationtool.model.Etape;
import ma.mpm.gov.automatiosationtool.model.Module;
import ma.mpm.gov.automatiosationtool.model.Test;
import ma.mpm.gov.automatiosationtool.model.TestEtape;
import ma.mpm.gov.automatiosationtool.model.TestEtapeId;

@Component
@Scope("session")
public class TestController {
	
	public TestController(){
		
	}
	
	
	@Autowired
	private GestionTest gTest;
	@Autowired
	private GestionTestEtape gTestEtape;
	@Autowired
	private GestionEtape gEtape;
	@Autowired
	private GestionModule gModule;
	
	private String nom;
	private String description;
	private int idtest;
	private int idmodule;
	private int numetape;
	
	private List<Module> listModules;
	private List<Etape> listEtapes;
	
	List<SelectItem> selectItemsEtape = new ArrayList<SelectItem>(); 
	List<SelectItem> selectItemsModule = new ArrayList<SelectItem>(); 

	@PostConstruct
	public void init (){
		listModules=gModule.findAll();
		listEtapes=gEtape.findAll(1);
		initSelectItems();
		initSelectItems2();

	}
	public void initSelectItems() {
		for(int i=0; i < listModules.size() ; i++){
			selectItemsModule.add( new SelectItem(listModules.get(i).getIdModule(), listModules.get(i).getNomModule()));
		}
	}

	public void initSelectItems2() {
		for(int i=0; i < listEtapes.size() ; i++){
			selectItemsEtape.add( new SelectItem(listEtapes.get(i).getNumEtape(), listEtapes.get(i).getNomEtape()));
		}
	}
	public void chargerEtape(){
		selectItemsEtape=new ArrayList<SelectItem>(); 
		listEtapes=gEtape.findAll(idmodule);
		initSelectItems2();
	}
	
	   public String add(){
		   String s="new";
		   
		   Date dNow = new Date( );
		   SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd");
		   
		   Test test=new Test();
		   test.setDate(ft.format(dNow));
		   test.setNomTest(nom);
			test.setDescription(description);

			gTest.saveorupdate(test);
			
			int t=test.getIdTest();
			System.out.println(numetape);
		for(int i=1; i <= numetape ; i++){
			gTestEtape.saveorupdate( new TestEtape(new TestEtapeId(t,i),test,gEtape.getById(i)));
		}
		
	//	test.setTestEtapes(testEtapes);
		
		 String message = "Votre test a été créé avec succés !!";
		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message)); 
		return s;
	   }
 
	   //getters and setters

	public int getNumetape() {
		return numetape;
	}
	public void setNumetape(int numetape) {
		this.numetape = numetape;
	}
	public GestionTest getgTest() {
		return gTest;
	}

	public void setgTest(GestionTest gTest) {
		this.gTest = gTest;
	}

	public GestionTestEtape getgTestEtape() {
		return gTestEtape;
	}

	public void setgTestEtape(GestionTestEtape gTestEtape) {
		this.gTestEtape = gTestEtape;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public GestionEtape getgEtape() {
		return gEtape;
	}
	public void setgEtape(GestionEtape gEtape) {
		this.gEtape = gEtape;
	}
	public GestionModule getgModule() {
		return gModule;
	}
	public void setgModule(GestionModule gModule) {
		this.gModule = gModule;
	}
	public int getIdtest() {
		return idtest;
	}
	public void setIdtest(int idtest) {
		this.idtest = idtest;
	}
	public int getIdmodule() {
		return idmodule;
	}
	public void setIdmodule(int idmodule) {
		this.idmodule = idmodule;
	}
	public int getnumetape() {
		return numetape;
	}
	public void setnumetape(int numetape) {
		this.numetape = numetape;
	}
	public List<Module> getListModules() {
		return listModules;
	}
	public void setListModules(List<Module> listModules) {
		this.listModules = listModules;
	}
	public List<Etape> getListEtapes() {
		return listEtapes;
	}
	public void setListEtapes(List<Etape> listEtapes) {
		this.listEtapes = listEtapes;
	}
	public List<SelectItem> getSelectItemsEtape() {
		return selectItemsEtape;
	}
	public void setSelectItemsEtape(List<SelectItem> selectItemsEtape) {
		this.selectItemsEtape = selectItemsEtape;
	}
	public List<SelectItem> getSelectItemsModule() {
		return selectItemsModule;
	}
	public void setSelectItemsModule(List<SelectItem> selectItemsModule) {
		this.selectItemsModule = selectItemsModule;
	}

	
	
}
