package app;

import domain.OTM.Sehirler;
import domain.OTM.Ulkeler;
import hibernate.HibernateUtil;
import org.hibernate.Session;

import java.util.Set;

public class OTMApp1 {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Ulkeler ulke = session.get(Ulkeler.class, 1L);

        Set sehirler = ulke.getSehirler();

        for(Object o : sehirler) {
            Sehirler sehir = (Sehirler) o;

            System.out.println(sehir.getSehirAdi());
        }
    }
}
