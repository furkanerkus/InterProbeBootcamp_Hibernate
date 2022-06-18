package domain.OTM;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Ulkeler")
public class Ulkeler {

    @SequenceGenerator(name = "ulke", sequenceName = "Ulke_Id_Seq")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ulke")
    private Long id;

    @Column(name = "Ulke_Adi", length = 100)
    private String ulkeAdi;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ulke", targetEntity = Sehirler.class)
    private Set sehirler = new HashSet();

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

    public Set getSehirler() {
        return sehirler;
    }

    public void setSehirler(Set sehirler) {
        this.sehirler = sehirler;
    }
}
