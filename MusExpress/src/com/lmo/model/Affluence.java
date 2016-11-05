package com.lmo.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="affluence")
public class Affluence implements Serializable
{

	int id_commentaire;
	private User user;
	private Musee musee;
	private String duree;
	private String text; 
	private Date  date;
	







	@Id
	@GeneratedValue
	@Column(name = "id_commentaire")
	public int getId_commentaire() 
	{
		return id_commentaire;
	}
	public void setId_commentaire(int id_commentaire) 
	{
		this.id_commentaire = id_commentaire;
	}


	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_user")
	public User getUser() 
	{
		return user;	
	}
	public void setUser(User user) 
	{
		this.user = user;
	}


	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_musee")
	public Musee getMusee() 
	{
		return musee;
	}
	public void setMusee(Musee musee) 
	{
		this.musee = musee;
	}


	@Column(name = "duree")
	public String getDuree() 
	{
		return duree;
	}
	public void setDuree(String duree) 
	{
		this.duree = duree;
	}


	@Column(name = "text")
	public String getText() 
	{
		return text;
	}
	public void setText(String text) 
	{
		this.text = text;
	}


	@Column(name = "emplacement")
	String emplacement;	
	public String getEmplacement() 
	{
		return emplacement;
	}
	public void setEmplacement(String emplacement) 
	{
		this.emplacement = emplacement;
	}


	@Column(name = "date", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDate() 
	{
		return date;
	}
	public void setDate(Date date) 
	{
		this.date = date;
	}



	public Affluence() {
		super();
	}



//	public Affluence(int id_commentaire, User user, Musee musee, String duree, String commentaire, String emplacement,
//			Date date) {
//		super();
//		this.id_commentaire = id_commentaire;
//		this.user = user;
//		this.musee = musee;
//		this.duree = duree;
//		this.commentaire = commentaire;
//		this.emplacement = emplacement;
//		this.date = date;
//	}
//
//
//
//	public Affluence(User user, Musee musee, String duree, String commentaire, String emplacement, Date date) {
//		super();
//		this.user = user;
//		this.musee = musee;
//		this.duree = duree;
//		this.commentaire = commentaire;
//		this.emplacement = emplacement;
//		this.date = date;
//	}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//








}
