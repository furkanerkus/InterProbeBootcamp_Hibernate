package domain.MTO;

import javax.persistence.*;

@Entity
@Table(name = "Ulke")
public class Ulke {

    @SequenceGenerator(name = "ulke", sequenceName = "Ulke_Id_Seq")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ulke")
    private Long id;

    @Column(name = "Ulke_Adı", length = 100)
    private String ulkeAdi;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUlkeAdi() {
        return ulkeAdi;
    }

    public void setUlkeAdi(String ulkeAdi) {
        this.ulkeAdi = ulkeAdi;
    }
}
