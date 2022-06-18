package app;

import domain.OTM.Sehirler;
import domain.OTM.Ulkeler;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OTMApp {

    public static void main(String[] args) {

        Ulkeler ulke = new Ulkeler();
        ulke.setUlkeAdi("Türkiye");

        Sehirler sehir = new Sehirler();
        sehir.setSehirAdi("İstanbul");
        sehir.setUlke(ulke);

        Sehirler sehir1 = new Sehirler();
        sehir1.setSehirAdi("Ankara");
        sehir1.setUlke(ulke);

        ulke.getSehirler().add(sehir);
        ulke.getSehirler().add(sehir1);

        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        session.merge(ulke);

        transaction.commit();

    }
}
