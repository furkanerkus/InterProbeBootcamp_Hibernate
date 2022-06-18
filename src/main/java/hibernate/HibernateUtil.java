package hibernate;

import domain.MTM.Kitap;
import domain.MTM.Yazar;
import domain.MTO.Sehir;
import domain.MTO.Ulke;
import domain.OTM.Sehirler;
import domain.OTM.Ulkeler;
import domain.OTO.Kisi;
import domain.OTO.ParmakIzi;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    public static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {

        try {

            Configuration cfg = new Configuration();

            cfg.addAnnotatedClass(Kisi.class);
            cfg.addAnnotatedClass(ParmakIzi.class);

            cfg.addAnnotatedClass(Kitap.class);
            cfg.addAnnotatedClass(Yazar.class);

            cfg.addAnnotatedClass(Sehir.class);
            cfg.addAnnotatedClass(Ulke.class);

            cfg.addAnnotatedClass(Sehirler.class);
            cfg.addAnnotatedClass(Ulkeler.class);


            SessionFactory sessionFactory = cfg.configure("hibernate.cfg.xml").buildSessionFactory();

            return sessionFactory;

        } catch (Exception e) {

            System.out.println("Session factory olusturulurken hata olustu" + e);
            throw new ExceptionInInitializerError(e);
        }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
