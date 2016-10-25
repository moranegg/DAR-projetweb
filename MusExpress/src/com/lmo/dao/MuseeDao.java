package com.lmo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.JSONException;

import com.lmo.hibernate.util.HibernateUtil;
import com.lmo.model.Musee;

public class MuseeDao 

{


	public static void addMusee	(String nom, String adresse, String ville, int departement, int codep, String ferme,
			String siteweb, String periode_ouverture, String fermeture_annuelle, double latitude, double longitude)
					throws JSONException
	{


		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction tx = null;	
		try {
			tx = session.getTransaction();
			tx.begin();
			Musee musee = new Musee
					(nom,adresse,ville,departement,codep,ferme,siteweb,periode_ouverture,fermeture_annuelle,latitude,longitude);
			session.save(musee);		
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}	

	}
}
