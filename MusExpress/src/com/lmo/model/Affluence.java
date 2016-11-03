package com.lmo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="musee")
public class Affluence implements Serializable
{
    @Id
    @Column(name="id_commentaire")
    @GeneratedValue(strategy = GenerationType.AUTO)
	int id_commentaire;
    
    @ManyToMany
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToMany
    @JoinColumn(name = "id_musee")
    private Musee musee;
    

    @Column(name = "longueur_file")
	String longueur_file;
    
    @Column(name = "commentaire")
	String commentaire; 
    
    @Column(name = "file")
	int file;
    
    @Column(name = "date")
	Date date;



	public Affluence() {
		super();
	}



	public Affluence(int id_commentaire, User user, Musee musee, String longueur_file, String commentaire, int file,
			Date date) {
		super();
		this.id_commentaire = id_commentaire;
		this.user = user;
		this.musee = musee;
		this.longueur_file = longueur_file;
		this.commentaire = commentaire;
		this.file = file;
		this.date = date;
	}



	public Affluence(User user, Musee musee, String longueur_file, String commentaire, int file, Date date) {
		super();
		this.user = user;
		this.musee = musee;
		this.longueur_file = longueur_file;
		this.commentaire = commentaire;
		this.file = file;
		this.date = date;
	}



	public int getId_commentaire() {
		return id_commentaire;
	}



	public void setId_commentaire(int id_commentaire) {
		this.id_commentaire = id_commentaire;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Musee getMusee() {
		return musee;
	}



	public void setMusee(Musee musee) {
		this.musee = musee;
	}



	public String getLongueur_file() {
		return longueur_file;
	}



	public void setLongueur_file(String longueur_file) {
		this.longueur_file = longueur_file;
	}



	public String getCommentaire() {
		return commentaire;
	}



	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}



	public int getFile() {
		return file;
	}



	public void setFile(int file) {
		this.file = file;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
