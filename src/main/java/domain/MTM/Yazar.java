package domain.MTM;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Yazar")
public class Yazar {

    @SequenceGenerator(name = "Yazar", sequenceName = "Yazar_Id_Seq")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Yazar")
    @Column(name = "Yazar_Id")
    private Long id;

    @Column(name = "Yazar_Adı")
    private String yazarAdi;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "yazarlar")
    private Set<Kitap> kitaplar = new HashSet<Kitap>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getYazarAdi() {
        return yazarAdi;
    }

    public void setYazarAdi(String yazarAdi) {
        this.yazarAdi = yazarAdi;
    }

    public Set<Kitap> getKitaplar() {
        return kitaplar;
    }

    public void setKitaplar(Set<Kitap> kitaplar) {
        this.kitaplar = kitaplar;
    }
}
