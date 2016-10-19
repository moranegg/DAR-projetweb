package com.lmo.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name="utilisateur")
public class User implements Serializable
{
     
    @Id 
    @GeneratedValue
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String codep;
 
    public User() {
    } 
     
    public User(String nom, String prenom, String email, String password,  String codep) 
    {
    	//this.id=id;
    	this.nom=nom;
    	this.prenom=prenom;
        this.email = email;
        this.password = password;
        this.codep = codep;

    }
    
    public User(String email, String password,  String codep) 
    {
        this.email = email;
        this.password = password;
        this.codep = codep;

    }
 
 
    public int getId() {
        return id;
    }
 
     public void setId(int id) {
        this.id = id;
    }
     
     public String getCodep() {
         return codep;
     }
  
      public void setCodep(String codep) {
         this.codep = codep;
     }
 
     public String getNom() {
         return nom;
     }
  
     public void setNom(String nom) {
         this.nom = nom;
     }
     
     public String getPrenom() {
         return prenom;
     }
  
     public void setPrenom(String prenom) {
         this.prenom = prenom;
     }
     
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }    
    
 
}
