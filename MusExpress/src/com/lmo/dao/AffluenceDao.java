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
import com.lmo.jobs.ApiMusee;
import com.lmo.model.Affluence;
import com.lmo.model.Musee;
import com.lmo.model.User;
/**
 * 
 * @author lina
 *
 */
public class AffluenceDao 
{
/**
 * Cette méthode permet d'ajouter une nouvelle affluence rédigée par un utilisateur dans la base de donnée 
 * @param id_user : id de l'utilisateur
 * @param id_musee : id du musée concerné
 * @param duree : durée d'attente dans la file
 * @param text : commentaire de l'utilisateur
 * @param emplacement : file extérieure ou intérieure
 * @return
 * @throws JSONException
 */
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


	/**
	 * Cette méthode permet de récupérer les affluences qui concernent un musée identifié par le paramètre en entrée 
	 * @param id du musée 
	 * @return List<Affluence>
	 */
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
	
	/**
	 * Cette méthode permet de récupérer les musées dot la dernière affluence enregistrée a une file d'attente de moins de 10mn
	 * dans le but de recommander aux utilisateurs des musées à visiter sans qu'il n'y ai trop d'attente
	 * @return List<Affluence>
	 */
	public static List<Affluence> getListOfAffluenceProposition()
	{
		List<Affluence> list = new ArrayList<Affluence>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null; 


		try {

			tx = session.getTransaction();
			tx.begin();
			list = session.createQuery("from Affluence a where a.duree='10min' order by a.date DESC")
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
	/***
	 * 	Cette méthode permer de récupérer les affluences selon le critère d'emplacement de la file d'attente (intérieur ou extérieur)
	 * Ces données seront manipulés pour la recommandation de musées en prenant compte de la météo

	 * @param emplacement
	 * @return List<Affluence>
	 */
	public static List<Affluence> getAffluenceByEmplacement(String emplacement)
	{
		List<Affluence> list = new ArrayList<Affluence>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null; 


		try {

			tx = session.getTransaction();
			tx.begin();
			list = session.createQuery("from Affluence a where a.emplacement='"+emplacement+"'")
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
