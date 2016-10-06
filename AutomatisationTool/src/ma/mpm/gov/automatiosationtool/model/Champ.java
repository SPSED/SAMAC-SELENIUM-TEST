package ma.mpm.gov.automatiosationtool.model;

// Generated 2 sept. 2016 15:01:40 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Champ generated by hbm2java
 */
@Entity
@Table(name = "champ", catalog = "project")
public class Champ implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer idChamp;
	private Etape etape;
	private Menu menu;
	private Action action;
	private TypeChamp typeChamp;
	private Selecteur selecteur;
	private String valeurSelecteur;
	private String texte;
	private String contexte;
	private String libelle;

	public Champ() {
	}


	

	public Champ(Integer idChamp, Etape etape, Menu menu, Action action, TypeChamp typeChamp, Selecteur selecteur,
			String valeurSelecteur, String texte, String contexte, String libelle) {
		super();
		this.idChamp = idChamp;
		this.etape = etape;
		this.menu = menu;
		this.action = action;
		this.typeChamp = typeChamp;
		this.selecteur = selecteur;
		this.valeurSelecteur = valeurSelecteur;
		this.texte = texte;
		this.contexte = contexte;
		this.libelle = libelle;
	}




	public Champ(Etape etape, Menu menu, Action action, TypeChamp typeChamp, Selecteur selecteur,
			String valeurSelecteur, String texte, String contexte, String libelle) {
		super();
		this.etape = etape;
		this.menu = menu;
		this.action = action;
		this.typeChamp = typeChamp;
		this.selecteur = selecteur;
		this.valeurSelecteur = valeurSelecteur;
		this.texte = texte;
		this.contexte = contexte;
		this.libelle = libelle;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_champ", unique = true, nullable = false)
	public Integer getIdChamp() {
		return this.idChamp;
	}

	public void setIdChamp(Integer idChamp) {
		this.idChamp = idChamp;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "num_etape")
	public Etape getEtape() {
		return this.etape;
	}

	public void setEtape(Etape etape) {
		this.etape = etape;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_menu")
	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_action", nullable = false)
	public Action getAction() {
		return this.action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_type", nullable = false)
	public TypeChamp getTypeChamp() {
		return this.typeChamp;
	}

	public void setTypeChamp(TypeChamp typeChamp) {
		this.typeChamp = typeChamp;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_selecteur", nullable = false)
	public Selecteur getSelecteur() {
		return this.selecteur;
	}

	public void setSelecteur(Selecteur selecteur) {
		this.selecteur = selecteur;
	}

	@Column(name = "valeur_selecteur", length = 100)
	public String getValeurSelecteur() {
		return this.valeurSelecteur;
	}

	public void setValeurSelecteur(String valeurSelecteur) {
		this.valeurSelecteur = valeurSelecteur;
	}

	@Column(name = "texte", length = 100)
	public String getTexte() {
		return this.texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	@Column(name = "contexte", length = 15)
	public String getContexte() {
		return this.contexte;
	}

	public void setContexte(String contexte) {
		this.contexte = contexte;
	}

	@Column(name = "libelle", length = 15)
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}	

}
