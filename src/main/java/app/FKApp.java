package app;

import domain.MTO.Sehir;
import domain.MTO.Ulke;

import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FKApp {

    public static void main(String[] args) {

        Ulke ulke = new Ulke();
        ulke.setUlkeAdi("Türkiye");

        Sehir sehir = new Sehir();
        sehir.setSehirAdi("İstanbul");
        sehir.setUlke(ulke);

        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        session.merge(sehir);

        transaction.commit();
    }
}
