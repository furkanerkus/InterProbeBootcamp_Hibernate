package domain;


import javax.persistence.*;

@Entity
@Table(name = "POJO_TABLE")
public class Pojo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
