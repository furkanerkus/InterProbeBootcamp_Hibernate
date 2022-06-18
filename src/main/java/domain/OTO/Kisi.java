package domain.OTO;

import javax.persistence.*;

@Entity
@Table(name = "KISI")
public class Kisi {

    @SequenceGenerator(name = "KISI", sequenceName = "KISI_ID_SEQ")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "KISI")
    @Column(name = "ID")
    private Long id;

    @Column(name = "ISIM", length = 100)
    private String isim;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false, mappedBy = "kisi")
    private ParmakIzi parmakIzi;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public ParmakIzi getParmakIzi() {
        return parmakIzi;
    }

    public void setParmakIzi(ParmakIzi parmakIzi) {
        this.parmakIzi = parmakIzi;
    }
}
