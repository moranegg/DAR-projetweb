package com.lmo.hibernate.util;


import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;


 
public class HibernateUtil 
{

    private static final SessionFactory sessionFactory;
    
    static 
    {
        try 
        {
            // Création de la SessionFactory depuis le fichier de configuration hibernate.cfg.xml
            sessionFactory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
        } 
        catch (Throwable ex) 
        {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() 
    {
        return sessionFactory;
    }
}



