package com.lmo.dao;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.JSONException;

import com.lmo.hibernate.util.HibernateUtil;
import com.lmo.model.Favoris;
import com.lmo.model.User;
import com.lmo.model.Musee;

import com.lmo.dao.UserDao;

public class FavorisDao {

	/*public static Favoris addFavoris	(int iduser, int idmusee)
					throws JSONException
	{


		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction tx = null;	
		try {
			tx = session.getTransaction();
			tx.begin();
			Favoris favoris = new Favoris (iduser, idmusee);
			session.save(favoris);		
			tx.commit();
			return favoris;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;	



	}*/





}
