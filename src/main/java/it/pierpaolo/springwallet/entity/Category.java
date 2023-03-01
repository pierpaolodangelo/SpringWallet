package it.pierpaolo.springwallet.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "CATEGORY")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categorySequenceGenerator")
    @SequenceGenerator(name = "categorySequenceGenerator", sequenceName = "CATEGORY_SEQUENCE", allocationSize = 100)
    private long id;
    @Column(name = "NAME")
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
