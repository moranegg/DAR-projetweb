package com.lmo.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="musee")
public class Musee implements Serializable
{
    @Id 
    @GeneratedValue
    private int id;
    private String nom;
    private String adresse;
    private String ville;
    private int departement;
    private int codep;  
    private String ferme;
    private String siteweb;
    private String periode_ouvertue;
    private String fermeture_annuelle;
    private double latitude; 
    private double longitude;
    private String type;
	private Set<User> userfav = new HashSet<User>(0);

    


	public Musee() 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public Musee(int id, String nom, String adresse, String ville, int departement, int codep, String ferme,
			String siteweb, String periode_ouvertue, String fermeture_annuelle, double latitude, double longitude, String type) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.ville = ville;
		this.departement = departement;
		this.codep = codep;
		this.ferme = ferme;
		this.siteweb = siteweb;
		this.periode_ouvertue = periode_ouvertue;
		this.fermeture_annuelle = fermeture_annuelle;
		this.latitude = latitude;
		this.longitude = longitude;
		this.type=type;
	}
	
	public Musee(String nom, String adresse, String ville, int departement, int codep, String ferme,
			String siteweb, String periode_ouvertue, String fermeture_annuelle, double latitude, double longitude, String type) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.ville = ville;
		this.departement = departement;
		this.codep = codep;
		this.ferme = ferme;
		this.siteweb = siteweb;
		this.periode_ouvertue = periode_ouvertue;
		this.fermeture_annuelle = fermeture_annuelle;
		this.latitude = latitude;
		this.longitude = longitude;
		this.type = type;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getDepartement() {
		return departement;
	}

	public void setDepartement(int departement) {
		this.departement = departement;
	}

	public int getCodep() {
		return codep;
	}

	public void setCodep(int codep) {
		this.codep = codep;
	}

	public String getFerme() {
		return ferme;
	}

	public void setFerme(String ferme) {
		this.ferme = ferme;
	}

	public String getSiteweb() {
		return siteweb;
	}

	public void setSiteweb(String siteweb) {
		this.siteweb = siteweb;
	}

	public String getPeriode_ouvertue() {
		return periode_ouvertue;
	}

	public void setPeriode_ouvertue(String periode_ouvertue) {
		this.periode_ouvertue = periode_ouvertue;
	}

	public String getFermeture_annuelle() {
		return fermeture_annuelle;
	}

	public void setFermeture_annuelle(String fermeture_annuelle) {
		this.fermeture_annuelle = fermeture_annuelle;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<User> getUserfav() {
		return userfav;
	}

	public void setUserfav(Set<User> userfav) {
		this.userfav = userfav;
	}

	
}