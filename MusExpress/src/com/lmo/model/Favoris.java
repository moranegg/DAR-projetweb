package com.lmo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="favoris")
public class Favoris implements Serializable
{

    @Id 
    @GeneratedValue
    private int id;
   
    @ManyToOne
    @JoinColumn(name = "id")
	private int iduser; 
    
    @ManyToOne
    @JoinColumn(name = "id")
	private int idmusee;

	public Favoris() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Favoris(int iduser, int idmusee) {
		super();
		this.iduser = iduser;
		this.idmusee = idmusee;
	} 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getIduser() {
		return iduser;
	}
	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	public int getIdmusee() {
		return idmusee;
	}
	public void setIdmusee(int idmusee) {
		this.idmusee = idmusee;
	}

}
