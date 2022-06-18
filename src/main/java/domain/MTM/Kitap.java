package domain.MTM;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Kitap")
public class Kitap {

    @SequenceGenerator(name = "Kitap", sequenceName = "Kitap_Id_Seq")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Kitap")
    @Column(name = "Kitap_Id")
    private Long id;

    @Column(name = "Kitap_Adı", length = 100)
    private String kitapAdi;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Yazar.class)

    private Set yazarlar = new HashSet();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKitapAdi() {
        return kitapAdi;
    }

    public void setKitapAdi(String kitapAdi) {
        this.kitapAdi = kitapAdi;
    }

    public Set getYazarlar() {
        return yazarlar;
    }

    public void setYazarlar(Set yazarlar) {
        this.yazarlar = yazarlar;
    }
}
