package app;

import domain.OTO.Kisi;
import domain.OTO.ParmakIzi;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OTOApp {

    public static void main(String[] args) {
        Kisi kisi = new Kisi();
        kisi.setIsim("Furkan");

        ParmakIzi parmakIzi = new ParmakIzi();
        parmakIzi.setDosyaNo("25A");

        parmakIzi.setKisi(kisi);
        kisi.setParmakIzi(parmakIzi);

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        parmakIzi = (ParmakIzi) session.merge(parmakIzi);

        transaction.commit();

        ParmakIzi parmakIzi1 = session.find(ParmakIzi.class, parmakIzi.getId());
        Kisi kisi1 = new Kisi();
        if(parmakIzi != null) {
            kisi1 = parmakIzi1.getKisi();
        }

        ParmakIzi parmakIzi2 = null;
        if(kisi1 != null) {
            Kisi kisi2 = session.find(Kisi.class, kisi1.getId());

            if(kisi2 != null) {
                parmakIzi2 = kisi2.getParmakIzi();
            }
        }

        System.out.println(kisi1.getIsim());
        System.out.println(parmakIzi2.getDosyaNo());
    }
}
