package app;

import domain.Pojo;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;
import java.util.Date;

public class PojoApp {

    public static void main(String[] args) {

        Pojo pojo = new Pojo();
        Date tarih = new Date();

        pojo.setAdi("Furkan");
        pojo.setDeger(new BigDecimal(5.123123));
        pojo.setTarih(tarih);
        pojo.setSaat(tarih);
        pojo.setTarihSaat(tarih);
        pojo.setGeciciGrup("Geçici Grup");



        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        session.merge(pojo);

        transaction.commit();

    }
}
