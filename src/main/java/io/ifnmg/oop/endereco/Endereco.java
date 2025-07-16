package io.ifnmg.oop.endereco;

import io.ifnmg.oop.repository.ProjectEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PostLoad;
import jakarta.persistence.Transient;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Endereco
        extends ProjectEntity
        implements Serializable
{
    @Serial
    private static final long serialVersionUID = 1L;

    @Column(length = 50, nullable = false)
    private String rua;
    @Column(nullable = false)
    private Integer numero;
    @Column(length = 50, nullable = true)
    private String complemento;
    @Column(length = 50, nullable = false)
    private String bairro;
    @Column(length = 50, nullable = false)
    private String cidade;

    public Endereco() {}
    public Endereco(String rua, Integer numero, String complemento, String bairro, String cidade) {
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    //Getters/Setters
    void setRua(String rua) {
        this.rua = rua;
    }
    String getRua() {
        return rua;
    }

    void setNumero(Integer numero) {
        this.numero = numero;
    }
    Integer getNumero() {
        return numero;
    }

    void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    String getComplemento() {
        return complemento;
    }

    void setBairro(String bairro) {
        this.bairro = bairro;
    }
    String getBairro() {
        return bairro;
    }

    void setCidade(String cidade) {
        this.cidade = cidade;
    }
    String getCidade() {
        return cidade;
    }

}
