package io.ifnmg.oop.tamanhoBuque;

import io.ifnmg.oop.repository.ProjectEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.io.Serial;
import java.io.Serializable;

@Entity
public class TamanhoBuque
        extends ProjectEntity
        implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private Integer numFlores;

    @Column(nullable = false)
    private Integer maxTipoFlores;

    public void setNumFlores(String numFlores) {
        // Não pode ser null
        if (numFlores == null || numFlores.isBlank()) {
            throw new IllegalArgumentException("O campo número de flores não pode estar em branco.");
        }

        // Percorre cada caractere da string.
        for (char c : numFlores.toCharArray()) {
            // Se encontrarmos qualquer caractere que não seja um dígito, lança exceção
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("O campo número de flores não deve conter letras ou símbolos.");
            }
        }

        int num = Integer.parseInt(numFlores);

        if (num <= 0) {
            throw new IllegalArgumentException("O campo número de flores não pode ser 0");
        }

        this.numFlores = num;
    }

    public void setMaxTipoFlores(String maxTipoFlores) {
        // Não pode ser null
        if (maxTipoFlores == null || maxTipoFlores.isBlank()) {
            throw new IllegalArgumentException("A quantidade máxima de tipo de flores não pode estar em branco.");
        }

        // Percorre cada caractere da string.
        for (char c : maxTipoFlores.toCharArray()) {
            // Se encontrarmos qualquer caractere que não seja um dígito, lança exceção
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("A quantidade máxima de tipo de flores não deve conter letras ou símbolos.");
            }
        }

        int num = Integer.parseInt(maxTipoFlores);

        if (num <= 0) {
            throw new IllegalArgumentException("A quantidade máxima de tipo de flores não pode ser 0");
        }

        this.maxTipoFlores = num;
    }

    public Integer getnumFlores() {
        return numFlores;
    }
    public Integer getmaxTipoFlores() {
        return maxTipoFlores;
    }

    @Override
    public String toString() {
        return "TamanhoBuque{" +
                "numFlores=" + numFlores +
                ", maxTipoFlores=" + maxTipoFlores +
                '}';
    }
}
