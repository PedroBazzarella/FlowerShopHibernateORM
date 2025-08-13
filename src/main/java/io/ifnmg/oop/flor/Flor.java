package io.ifnmg.oop.flor;

import io.ifnmg.oop.repository.ProjectEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.io.Serial;
import java.io.Serializable;

@Entity
public class Flor
        extends ProjectEntity
        implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private String especie;

    @Column(nullable = false)
    private Integer estoque;

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return "Flor{" +
                "especie='" + especie + '\'' +
                ", estoque=" + estoque +
                '}';
    }
}
