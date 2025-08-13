package io.ifnmg.oop.buque;

import io.ifnmg.oop.repository.ProjectEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.io.Serial;
import java.io.Serializable;

@Entity
public class Buque
        extends ProjectEntity
        implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private Integer numTipoFlores;

    @Column
    private String recado;

    public Integer getNumTipoFlores() {
        return numTipoFlores;
    }

    public void setNumTipoFlores(Integer numTipoFlores) {
        this.numTipoFlores = numTipoFlores;
    }

    public String getRecado() {
        return recado;
    }

    public void setRecado(String recado) {
        this.recado = recado;
    }

    @Override
    public String toString() {
        return "Buque{" +
                "numTipoFlores=" + numTipoFlores +
                ", recado='" + recado + '\'' +
                '}';
    }
}
