package com.lmo.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
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


	public static List<Affluence> getListOfAffluences(String id){
		List<Affluence> list = new ArrayList<Affluence>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null; 


		try {

			tx = session.getTransaction();
			tx.begin();
			list = session.createQuery("from Affluence a where a.musee.id='"+id+"' order by a.date DESC")
					.setMaxResults(10)
					.list();                        
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	
	
	public static List<Affluence> getListOfAffluenceProposition()
	{
		List<Affluence> list = new ArrayList<Affluence>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null; 


		try {

			tx = session.getTransaction();
			tx.begin();
			list = session.createQuery("from Affluence a where a.duree='10min' order by a.date DESC")
					//.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
					//.setProjection(Projections.distinct(Projections.property("id_commentaire")))
					//.setMaxResults(10)
					.list();                        
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	
	public static List<Affluence> getAffluenceByEmplacement(String emplacement)
	{
		List<Affluence> list = new ArrayList<Affluence>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null; 


		try {

			tx = session.getTransaction();
			tx.begin();
			list = session.createQuery("from Affluence a where a.emplacement='"+emplacement+"'")
					//.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
					//.setProjection(Projections.distinct(Projections.property("id_commentaire")))
					//.setMaxResults(10)
					.list();                        
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}


}
