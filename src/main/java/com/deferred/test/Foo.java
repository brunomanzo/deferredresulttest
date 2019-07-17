package com.deferred.test;

import javax.persistence.*;

@Entity
@NamedQueries(value = {
        @NamedQuery(name = "Foo.getByBar", query = "select foo from Foo foo where foo.bar=:bar")
})
public class Foo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bar;

    public Long getId() {
        return id;
    }

    public String getBar() {
        return bar;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBar(String bar) {
        this.bar = bar;
    }
}
