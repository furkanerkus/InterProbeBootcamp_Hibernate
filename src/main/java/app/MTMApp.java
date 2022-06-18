package app;

import domain.MTM.Kitap;
import domain.MTM.Yazar;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

public class MTMApp {

    public static void main(String[] args) {

        Kitap kitap = new Kitap();
        kitap.setKitapAdi("Çalıkuşu");

        Yazar yazar = new Yazar();
        yazar.setYazarAdi("Yaşar Nuri Gültekin");

        kitap.getYazarlar().add(yazar);
        yazar.getKitaplar().add(kitap);

        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        kitap = (Kitap) session.merge(kitap);

        transaction.commit();

        Kitap kitap1 = session.find(Kitap.class, kitap.getId());
        Set yazarlar = kitap1.getYazarlar();

        Set<Kitap> kitapSet = new HashSet<>();

        for(Object yazar1 : yazarlar) {
            Yazar yazar2 = (Yazar) yazar1;
            System.out.println(yazar2.getYazarAdi());
            kitapSet.addAll(yazar2.getKitaplar());
        }

        for(Kitap kitap2 : kitapSet) {
            System.out.println(kitap2.getKitapAdi());
        }


    }
}
