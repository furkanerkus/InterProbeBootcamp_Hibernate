package domain.OTM;



import javax.persistence.*;

@Entity
@Table(name = "Sehirler")
public class Sehirler {

    @SequenceGenerator(name = "sehir", sequenceName = "Sehir_Id_Seq")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sehir")
    private Long id;

    @Column(name = "Sehir_Adi", length = 100)
    private String sehirAdi;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private Ulkeler ulke;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSehirAdi() {
        return sehirAdi;
    }

    public void setSehirAdi(String sehirAdi) {
        this.sehirAdi = sehirAdi;
    }

    public Ulkeler getUlke() {
        return ulke;
    }

    public void setUlke(Ulkeler ulke) {
        this.ulke = ulke;
    }
}