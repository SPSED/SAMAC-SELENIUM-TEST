package ma.mpm.gov.automatiosationtool.controllers;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ma.mpm.gov.automatiosationtool.gestion.Interface.GestionAction;
import ma.mpm.gov.automatiosationtool.gestion.Interface.GestionChamp;
import ma.mpm.gov.automatiosationtool.gestion.Interface.GestionEtape;
import ma.mpm.gov.automatiosationtool.gestion.Interface.GestionMenu;
import ma.mpm.gov.automatiosationtool.gestion.Interface.GestionModule;
import ma.mpm.gov.automatiosationtool.gestion.Interface.GestionSelecteur;
import ma.mpm.gov.automatiosationtool.gestion.Interface.GestionTypeChamp;
import ma.mpm.gov.automatiosationtool.model.Action;
import ma.mpm.gov.automatiosationtool.model.Champ;
import ma.mpm.gov.automatiosationtool.model.Etape;
import ma.mpm.gov.automatiosationtool.model.Menu;
import ma.mpm.gov.automatiosationtool.model.Module;
import ma.mpm.gov.automatiosationtool.model.Selecteur;
import ma.mpm.gov.automatiosationtool.model.TypeChamp;


@Component
@Scope("session")
public class ChampController implements Serializable{

	private static final long serialVersionUID = 1L;


	
	private Champ champ;
	private int idchamp;
	private  Module module;
	private int idmodule;
	private String nommodule;
	private Etape etape;
	private int numetape;
	private String nometape;
	private Menu menu;
	private String nommenu;
	private int idmenu;
	private TypeChamp typeChamp;
	private int idtype;
	private Action action;
	private int idaction;
	private Selecteur selecteur;
	private int idselecteur;
    private String valeurSelecteur;
	private String contexte;
	private String texte;
	private Date texteDate;
	private String libelle;
	
	@Autowired
	private GestionEtape gEtape;
	@Autowired
	private GestionModule gModule;
	@Autowired
	private GestionTypeChamp gTypeChamp;
	@Autowired
	private GestionChamp gChamp;
	@Autowired
	private GestionMenu gMenu;
	@Autowired
	private GestionSelecteur gSelecteur;
	@Autowired
	private GestionAction gAction;
	
	private List<Module> listModules;
	private List<Etape> listEtapes;
	private List<TypeChamp> listTypes;
	private List<Menu> listMenus;
	private List<Selecteur> listSelecteurs;
	private List<Action> listActions;
	private List<Champ> listChamps; 

	
	List<SelectItem> selectItemsModule = new ArrayList<SelectItem>(); 
	List<SelectItem> selectItemsEtape  = new ArrayList<SelectItem>(); 
	List<SelectItem> selectItemsMenu   = new ArrayList<SelectItem>(); 
	List<SelectItem> selectItemsType   = new ArrayList<SelectItem>();
	List<SelectItem> selectItemsAction = new ArrayList<SelectItem>();
	List<SelectItem> selectItemsSelecteur= new ArrayList<SelectItem>();
	List<SelectItem> selectItemsChamp= new ArrayList<SelectItem>();

	public ChampController() {
		super(); 
	}
	
	@PostConstruct
	public void init(){
		listModules=gModule.findAll();
		listEtapes=gEtape.findAll(1);
		listTypes=gTypeChamp.findAll();
		listMenus=gMenu.findAll(2);
		listActions=gAction.findAll();
		listSelecteurs=gSelecteur.findAll();
		listChamps=gChamp.findAll();
/*		gChamp.increase(99);
*/		initSelectItems();
		initSelectItems2();
		initSelectItems3();
		initSelectItems5();
		initSelectItems6();
		initSelectItems7();

	}

	// conversion en SelectItems
	
	
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
	
	public void initSelectItems3() {
			selectItemsMenu.add( new SelectItem(0,"pas de menu"));
	
	}
	public void initSelectItems4() {
		for(int i=0; i < listMenus.size() ; i++){
			selectItemsMenu.add( new SelectItem(listMenus.get(i).getIdMenu(), listMenus.get(i).getNomMenu()));
		}
	}
	public void initSelectItems5() {
		for(int i=0; i < listTypes.size() ; i++){
			selectItemsType.add( new SelectItem(listTypes.get(i).getIdType(), listTypes.get(i).getNomType()));
		}
	}
	
	public void initSelectItems6() {
		for(int i=0; i < listActions.size() ; i++){
			selectItemsAction.add( new SelectItem(listActions.get(i).getIdAction(), listActions.get(i).getAction()));
		}
	}
	
	public void initSelectItems7() {
		for(int i=0; i < listSelecteurs.size() ; i++){
			selectItemsSelecteur.add( new SelectItem(listSelecteurs.get(i).getIdSelecteur(), listSelecteurs.get(i).getTypeSelecteur()));
		}
	}
	
	public void initSelectItems8() {
		for(int i=0; i < listChamps.size() ; i++){
			selectItemsChamp.add( new SelectItem(listChamps.get(i).getIdChamp(), listChamps.get(i).getLibelle()));
		}
	}
	//ajax 
	
	public void chargerEtape(){
		selectItemsEtape=new ArrayList<SelectItem>(); 
		listEtapes=gEtape.findAll(idmodule);
		initSelectItems2();
	}

	public void chargerEtape2(){
		selectItemsEtape=new ArrayList<SelectItem>(); 
		listEtapes=gEtape.findAll(champ.getEtape().getModule().getIdModule());
		initSelectItems2();
	}
	
	public void chargerMenu(){
		chargermenu(numetape,contexte);
	}
	
	public void chargerMenu2(){
		chargermenu(champ.getEtape().getNumEtape(),champ.getContexte());
	}
	
	public void chargermenu(int num,String cont){
		
		if(gMenu.findAll(num).size()==0){
			selectItemsMenu=new ArrayList<SelectItem>(); 
			initSelectItems3();
		}else if("traitement".equals(cont)){
			selectItemsMenu=new ArrayList<SelectItem>(); 
		    listMenus=gMenu.findAll(num);
		    initSelectItems4();
		}else{
			selectItemsMenu=new ArrayList<SelectItem>(); 
			initSelectItems3();}
		}
	
	public void chargerChamps(){
		selectItemsChamp=new ArrayList<SelectItem>(); 
		listChamps=gChamp.findBy(idmenu);
		System.out.println(listChamps.size());
		initSelectItems8();
	}
	//navigation
	
	public String delete(Champ c){
		gChamp.delete(c);		
		listChamps=gChamp.findAll();

		return "delete";
	}
	
	public String edit(Champ c){
		champ=c;
		if(champ.getMenu()==null){
			Menu m=new Menu();
			m.setIdMenu(0);
			champ.setMenu(m);}
			
			listEtapes=gEtape.findAll(champ.getEtape().getModule().getIdModule());
			initSelectItems2();
			listMenus=gMenu.findAll(champ.getEtape().getNumEtape());
			chargerMenu2();		
		return "edit";
	}
	
	
	public String details(Champ c){
		champ=c;
		return "detail";
	}
	public String edit(){
		 if(champ.getMenu().getIdMenu()==0)
			 champ.setMenu(null);
		gChamp.saveorupdate(champ);
		listChamps=gChamp.findAll();
		return "table";
		}
	
	public String champ(){
		return "champ";
	}
	public String test(){
		return "test";
	}
	
	public String table(){
		return "table";
	}
	   public String add1(){
		etape = gEtape.getById(numetape);
		action = gAction.getById(idaction);
		typeChamp = gTypeChamp.getById(idtype);
		selecteur = gSelecteur.getById(idselecteur);
		if (texteDate != null) {
			texte = texteDate.toString();
		}
		if (idmenu == 0) {
			menu = null;
			
		} else {
			menu = gMenu.getById(idmenu);
			champ = new Champ(etape, menu, action, typeChamp, selecteur, valeurSelecteur, texte, contexte, libelle);
		}

		String message;
		libelle = "";
		texte = "";
		if (gChamp.saveorupdate(champ)) {
			message = "Votre champ a �t� ajout� avec succ�s !!";
		}
		   else {message="Erreur lors de la cr�ation de votre champ";}
		    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message)); 

		return "new";
	   }
	   
	   public static Date stringToDate(String date) {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	        try {
	            return dateFormat.parse(date);
	        } catch (ParseException e) {
	            return null;
	        }
	    }
	   
	   public static String dateToString(Date date) {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	        return dateFormat.format(date);
	    }
	   
	    public String find (){
	    	nommodule=gModule.getById(idmodule).getNomModule();
	    	nometape=gEtape.getById(numetape).getNomEtape();
	    	if(idmenu!=0)
	    	nommenu=gMenu.getById(idmenu).getNomMenu();
	    	else{
	    		nommenu=null;
	    	}
	    	listChamps=gChamp.findBy(nommodule, nometape, nommenu,libelle);
	    	libelle="";
	    	return "table";
	    }
	  
	    public String neww(){
	    	return "new";
	    }
	    public String home(){
	    	return "home";
	    }
	    public String display(){
	    	listChamps=gChamp.findAll();
	    	return "display";
	    }
	    
	    
	   //rendred functions
	   public boolean isTypeDate2(){
			if(champ.getTypeChamp().getIdType()==3) {
				return true;
			} else {
				return false;
			}
	    }
	   public boolean isTypeDate(){
			if(idtype==3) {
				return true;
			} else {
				return false;
			}
	    }
	   public boolean isMenu(){
				if(idmenu!=0) {
					return true;
				} else {
					return false;
				}
		    }
		public TimeZone getTimeZone() {
	        return TimeZone.getDefault();
	    }    
		
		
		
		
		
		
		

	//getters and setters
	
	
	
	public Champ getChamp() {
		return champ;
	}

	public int getIdaction() {
		return idaction;
	}

	public void setIdaction(int idaction) {
		this.idaction = idaction;
	}

	public List<SelectItem> getSelectItemsAction() {
		return selectItemsAction;
	}

	public void setSelectItemsAction(List<SelectItem> selectItemsAction) {
		this.selectItemsAction = selectItemsAction;
	}


	public int getIdmenu() {
		return idmenu;
	}

	public void setIdmenu(int idmenu) {
		this.idmenu = idmenu;
	}

	public int getIdtype() {
		return idtype;
	}

	public void setIdtype(int idtype) {
		this.idtype = idtype;
	}

	public List<SelectItem> getSelectItemsMenu() {
		return selectItemsMenu;
	}

	public void setSelectItemsMenu(List<SelectItem> selectItemsMenu) {
		this.selectItemsMenu = selectItemsMenu;
	}

	public List<SelectItem> getSelectItemsEtape() {
		return selectItemsEtape;
	}

	public void setSelectItemsEtape(List<SelectItem> selectItemsEtape) {
		this.selectItemsEtape = selectItemsEtape;
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


	public List<TypeChamp> getListTypes() {
		return listTypes;
	}

	public void setListTypes(List<TypeChamp> listTypes) {
		this.listTypes = listTypes;
	}

	public List<SelectItem> getSelectItemsType() {
		return selectItemsType;
	}

	public void setSelectItemsType(List<SelectItem> selectItemsType) {
		this.selectItemsType = selectItemsType;
	}

	public List<Menu> getListMenus() {
		return listMenus;
	}

	public void setListMenus(List<Menu> listMenus) {
		this.listMenus = listMenus;
	}

	public List<Selecteur> getListSelecteurs() {
		return listSelecteurs;
	}

	public void setListSelecteurs(List<Selecteur> listSelecteurs) {
		this.listSelecteurs = listSelecteurs;
	}

	public List<Action> getListActions() {
		return listActions;
	}

	public void setListActions(List<Action> listActions) {
		this.listActions = listActions;
	}

	public List<Champ> getListChamps() {
		return listChamps;
	}

	public void setListChamps(List<Champ> listChamps) {
		this.listChamps = listChamps;
	}

	public List<SelectItem> getSelectItemsModule() {
		return selectItemsModule;
	}

	public void setSelectItemsModule(List<SelectItem> selectItemsModule) {
		this.selectItemsModule = selectItemsModule;
	}

	public void setChamp(Champ champ) {
		this.champ = champ;
	}


	public GestionChamp getgChamp() {
		return gChamp;
	}
	public void setgChamp(GestionChamp gChamp) {
		this.gChamp = gChamp;
	}
	public GestionMenu getgMenu() {
		return gMenu;
	}
	public void setgMenu(GestionMenu gMenu) {
		this.gMenu = gMenu;
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

	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}


	public String getValeurSelecteur() {
		return valeurSelecteur;
	}

	public void setValeurSelecteur(String valeurSelecteur) {
		this.valeurSelecteur = valeurSelecteur;
	}

	public String getContexte() {
		return contexte;
	}
	public void setContexte(String contexte) {
		this.contexte = contexte;
	}
	public String getTexte() {
		return texte;
	}
	public void setTexte(String texte) {
		this.texte = texte;
	}
	public Etape getEtape() {
		return etape;
	}
	public void setEtape(Etape etape) {
		this.etape = etape;
	}

	public int getIdmodule() {
		return idmodule;
	}

	public void setIdmodule(int idmodule) {
		this.idmodule = idmodule;
	}

	public List<SelectItem> getSelectItemsSelecteur() {
		return selectItemsSelecteur;
	}

	public void setSelectItemsSelecteur(List<SelectItem> selectItemsSelecteur) {
		this.selectItemsSelecteur = selectItemsSelecteur;
	}

	public int getNumetape() {
		return numetape;
	}

	public void setNumetape(int numetape) {
		this.numetape = numetape;
	}


	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public TypeChamp getTypeChamp() {
		return typeChamp;
	}
	public void setTypeChamp(TypeChamp typeChamp) {
		this.typeChamp = typeChamp;
	}
	
	
	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public Selecteur getSelecteur() {
		return selecteur;
	}
	public void setSelecteur(Selecteur selecteur) {
		this.selecteur = selecteur;
	}
	public GestionTypeChamp getgTypeChamp() {
		return gTypeChamp;
	}
	public void setgTypeChamp(GestionTypeChamp gTypeChamp) {
		this.gTypeChamp = gTypeChamp;
	}
	public GestionSelecteur getgSelecteur() {
		return gSelecteur;
	}
	public void setgSelecteur(GestionSelecteur gSelecteur) {
		this.gSelecteur = gSelecteur;
	}
	public GestionAction getgAction() {
		return gAction;
	}
	public void setgAction(GestionAction gAction) {
		this.gAction = gAction;
	}

	public int getIdselecteur() {
		return idselecteur;
	}

	public void setIdselecteur(int idselecteur) {
		this.idselecteur = idselecteur;
	}

	public String getNommodule() {
		return nommodule;
	}

	public void setNommodule(String nommodule) {
		this.nommodule = nommodule;
	}

	public String getNometape() {
		return nometape;
	}

	public void setNometape(String nometape) {
		this.nometape = nometape;
	}

	public String getNommenu() {
		return nommenu;
	}

	public void setNommenu(String nommenu) {
		this.nommenu = nommenu;
	}

	public Date getTexteDate() {
		return texteDate;
	}

	public void setTexteDate(Date texteDate) {
		this.texteDate = texteDate;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<SelectItem> getSelectItemsChamp() {
		return selectItemsChamp;
	}

	public void setSelectItemsChamp(List<SelectItem> selectItemsChamp) {
		this.selectItemsChamp = selectItemsChamp;
	}

	public int getIdchamp() {
		return idchamp;
	}

	public void setIdchamp(int idchamp) {
		this.idchamp = idchamp;
	}
	
}
