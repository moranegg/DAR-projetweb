package com.lmo.dao;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.JSONException;

import com.lmo.hibernate.util.HibernateUtil;
import com.lmo.model.Affluence;

public class AffluenceDao 
{

	public static Affluence addAffluence (int id_user, int id_musee, String longueur_file, String commentaire, int file, Date date)
			throws JSONException
	{


		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction tx = null;	
		try {
			tx = session.getTransaction();
			tx.begin();
			Affluence affluence = new Affluence (UserDao.getUserById(String.valueOf(id_user)), MuseeDao.getMuseeById(String.valueOf(id_musee)), longueur_file, commentaire, file, date);
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
