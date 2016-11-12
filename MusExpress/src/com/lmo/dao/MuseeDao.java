package com.lmo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.JSONException;

import com.lmo.hibernate.util.HibernateUtil;
import com.lmo.model.Affluence;
import com.lmo.model.Musee;
import com.lmo.model.User;

public class MuseeDao 

{


	public static void addMusee	(String nom, String adresse, String ville, int departement, int codep, String ferme,
			String siteweb, String periode_ouverture, String fermeture_annuelle, double latitude, double longitude, String type)
					throws JSONException
	{


		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction tx = null;	
		try {
			tx = session.getTransaction();
			tx.begin();
			Musee musee = new Musee (nom, adresse, ville, departement,codep, ferme,
					siteweb,periode_ouverture, fermeture_annuelle, latitude, longitude,type);
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
	
	
	   public static Musee getMuseeById(String id) 
	    {
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        Transaction tx = null;
	        Musee musee = null;
	        try 
	        {
	            tx = session.getTransaction();
	            tx.begin();
	            Query query = session.createQuery("from Musee where id='"+id+"'");
	            musee = (Musee)query.uniqueResult();
	            tx.commit();
	        }
	        catch (Exception e) 
	        {
	            if (tx != null) 
	            {
	                tx.rollback();
	            }
	            e.printStackTrace();
	        } 
	        finally 
	        {
	            session.close();
	        }
	        return musee;
	    }
	   
	    public static List<Musee> getListOfMusees(String nom){
	        List<Musee> list = new ArrayList<Musee>();
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        Transaction tx = null; 


	        try {

	            tx = session.getTransaction();
	            tx.begin();
	            list = session.createQuery("from Musee m where m.nom like :searchKey")
	        	        .setParameter("searchKey", "%" + nom + "%")
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
	    

//		public static Set<Affluence> listAffluence (String id)
//				throws JSONException
//		{
//
//			Session session = HibernateUtil.getSessionFactory().openSession();
//
//			Transaction tx = null;	
//			try {
//				tx = session.getTransaction();
//				tx.begin();
//				Musee musee = MuseeDao.getMuseeById(id);
//				System.out.println("musee"+musee);
//			    Set<Affluence> c = musee.getAffluences();
//			    System.out.println("coucou"+c);
//			    tx.commit();
//				return c;
//			} catch (Exception e) {
//				if (tx != null) {
//					tx.rollback();
//				}
//				e.printStackTrace();
//			} finally {
//				session.close();
//			}
//			return null;	
//		}

	    public static List<Musee> getListMuseesProximite(String id)
	    {
	        List<Musee> list = new ArrayList<Musee>();
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        Transaction tx = null; 


	        try {
	        	
	        	Musee m = getMuseeById(id);
	        	String departement = String.valueOf(m.getDepartement());
	            tx = session.getTransaction();
	            tx.begin();
	            list = session.createQuery("from Musee m where m.id!='"+id+"' and m.departement='"+departement+"'")
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
	    

	    public static ArrayList<Musee> getAllMusees(){
	        ArrayList<Musee> list = new ArrayList<Musee>();
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        Transaction tx = null; 


	        try {

	            tx = session.getTransaction();
	            tx.begin();
	            list = (ArrayList<Musee>) session.createQuery("from Musee").list();                        
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

