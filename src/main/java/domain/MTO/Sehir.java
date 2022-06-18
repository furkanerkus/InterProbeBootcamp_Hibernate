package domain.MTO;


import javax.persistence.*;

@Entity
@Table(name = "Sehir", indexes = @Index(name = "IX_SEHIR_ADI_ID", columnList = "Sehir_Adi, ID", unique = true))
public class Sehir {

    @SequenceGenerator(name = "sehir", sequenceName = "Sehir_Id_Seq")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sehir")
    private Long id;

    @Column(name = "Sehir_Adi", length = 100)
    private String sehirAdi;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ULKE", nullable = false, foreignKey = @ForeignKey(name = "FK_SEHIR_ULKE",value = ConstraintMode.CONSTRAINT, foreignKeyDefinition = " UNIQUE(ID) "))
    private Ulke ulke;

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

    public Ulke getUlke() {
        return ulke;
    }

    public void setUlke(Ulke ulke) {
        this.ulke = ulke;
    }
}
