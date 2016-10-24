package com.lmo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.json.JSONException;

import com.lmo.model.Musee;

public class MuseeDao 

{


	public static void addMusee	(String nom, String adresse, String ville, int departement, int codep, String ferme,
			String siteweb, String periode_ouvertue, String fermeture_annuelle, double latitude, double longitude)
			throws JSONException
	{
		SessionFactory sessFact = new 
				Configuration().configure().buildSessionFactory();
		Session sess = sessFact.openSession();
		Transaction tran =sess.beginTransaction();;
		
		    Musee musee = new Musee();
			musee.setNom(nom);
			musee.setAdresse(adresse);
			musee.setVille(ville);
			musee.setDepartement(departement);
			musee.setCodep(codep);
			musee.setFerme(ferme);
			musee.setSiteweb(siteweb);
			musee.setPeriode_ouvertue(periode_ouvertue);
			musee.setFermeture_annuelle(fermeture_annuelle);
			musee.setLatitude(latitude);
			musee.setLongitude(longitude);
		
			sess.save(musee);
			tran.commit();
	}
}
