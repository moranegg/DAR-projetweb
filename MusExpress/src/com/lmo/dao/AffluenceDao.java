package com.lmo.dao;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.JSONException;

import com.lmo.hibernate.util.HibernateUtil;
import com.lmo.model.Affluence;
import com.lmo.model.Musee;
import com.lmo.model.User;

public class AffluenceDao 
{

	public static Affluence addAffluence (String id_user, String id_musee, String duree, String text, String emplacement)
			throws JSONException
	{


		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction tx = null;	
		try {
			tx = session.getTransaction();
			tx.begin();
			User user = UserDao.getUserById(id_user);
			Musee musee = MuseeDao.getMuseeById(id_musee);
			Affluence affluence = new Affluence();
			affluence.setMusee(musee);
			affluence.setUser(user);
			affluence.setDuree(duree);
			affluence.setText(text);
			affluence.setEmplacement(emplacement);
			java.util.Date dt = new java.util.Date();
			affluence.setDate(dt);
			session.save(affluence);		
			tx.commit();
			return affluence;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;	



	}

}
