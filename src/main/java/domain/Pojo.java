package domain;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "POJO_TABLE")
public class Pojo {

    @SequenceGenerator(name = "seq", sequenceName = "POJO_TABLE_ID_SEQ", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq") // SequenceGenerator name ile aynı olması lazım.
    @Column(name = "ID")
    private Long id;

    @Column(name = "ADI", length = 100) // nullable ==> boş bırakılamaz, insertable ==> insert sorgusuna dahil edilmiyor, updatable ==> update sorgusuna dahil edilmiyor
    private String adi;

    @Column(name = "Değer", precision = 15, scale = 2) // precision ==> tam kısımdaki basamak sayısı, scale ==> virgülden sonraki basamak sayısı
    private BigDecimal deger;

    @Column(name = "TARİH")
    @Temporal(TemporalType.DATE)
    private Date tarih;

    @Column(name = "SAAT")
    @Temporal(TemporalType.TIME)
    private Date saat;

    @Column(name = "TARİH_SAAT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tarihSaat;

    @Transient // Oluşturulan değişkenin DB de sütun olmasını engelliyor. Hiçbir anatosyon konulmazsa dahi otomatik sütun oluşturuluyor.
    private String geciciGrup;

    @Column(name = "BÜYÜK_STRING")
    @Lob
    private String buyukString;

    @Column(name = "BÜYÜK_BLOB")
    @Lob
    private byte[] buyukBlob;

    @Column(name = "BÜYÜK_CLOB")
    @Lob
    private char[] buyukClob;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public BigDecimal getDeger() {
        return deger;
    }

    public void setDeger(BigDecimal deger) {
        this.deger = deger;
    }

    public Date getTarih() {
        return tarih;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }

    public Date getSaat() {
        return saat;
    }

    public void setSaat(Date saat) {
        this.saat = saat;
    }

    public Date getTarihSaat() {
        return tarihSaat;
    }

    public void setTarihSaat(Date tarihSaat) {
        this.tarihSaat = tarihSaat;
    }

    public String getGeciciGrup() {
        return geciciGrup;
    }

    public void setGeciciGrup(String geciciGrup) {
        this.geciciGrup = geciciGrup;
    }

    public String getBuyukString() {
        return buyukString;
    }

    public void setBuyukString(String buyukString) {
        this.buyukString = buyukString;
    }

    public byte[] getBuyukBlob() {
        return buyukBlob;
    }

    public void setBuyukBlob(byte[] buyukBlob) {
        this.buyukBlob = buyukBlob;
    }

    public char[] getBuyukClob() {
        return buyukClob;
    }

    public void setBuyukClob(char[] buyukClob) {
        this.buyukClob = buyukClob;
    }
}
