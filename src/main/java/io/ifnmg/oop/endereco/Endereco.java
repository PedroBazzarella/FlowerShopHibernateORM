package io.ifnmg.oop.endereco;

import io.ifnmg.oop.repository.ProjectEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PostLoad;
import jakarta.persistence.Transient;

import javax.swing.*;
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
    public Endereco(String rua, String numero, String complemento, String bairro, String cidade) {
        this.setRua(rua);
        this.setNumero(numero);
        this.setComplemento(complemento);
        this.setBairro(bairro);
        this.setCidade(cidade);
    }

    //Getters/Setters
    public void setRua(String rua) {

        // Não pode ser null ou string vazia
        if (rua == null || rua.isBlank()) {
            throw new IllegalArgumentException("O campo rua não pode estar em branco.");
        }

        // Limite de tamanho (50 caracteres)
        if (rua.length() > 50) {
            throw new IllegalArgumentException("O nome da rua não pode exceder 50 caracteres.");
        }

        this.rua = rua;
    }
    public void setNumero(String numero) {
        // Não pode ser null
        if (numero == null || rua.isBlank()) {
            throw new IllegalArgumentException("O campo número não pode estar em branco.");
        }

        // Percorre cada caractere da string.
        for (char c : numero.toCharArray()) {
            // Se encontrarmos qualquer caractere que não seja um dígito, lança exceção
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("O campo número não deve conter letras ou símbolos.");
            }
        }

        int num = Integer.parseInt(numero);

//        // Deve ser um número positivo -> já é tratado no loop anterior
//        if (num <= 0) {
//            throw new IllegalArgumentException("O número deve ser um valor positivo.");
//        }

        this.numero = num;
    }

    public void setComplemento(String complemento) {
        // Limite de tamanho (50 caracteres)
        if (complemento.length() > 50) {
            throw new IllegalArgumentException("O complemento não pode exceder 50 caracteres.");
        }

        this.complemento = complemento;
    }

    public void setBairro(String bairro) {
        // Não pode ser null
        if (bairro == null || bairro.isBlank()) {
            throw new IllegalArgumentException("O campo bairro não pode estar em branco.");
        }
        // Limite de tamanho (50 caracteres)
        if (bairro.length() > 50) {
            throw new IllegalArgumentException("O bairro não pode exceder 50 caracteres.");
        }

        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        // Não pode ser null
        if (cidade == null || cidade.isBlank()) {
            throw new IllegalArgumentException("A cidade não pode estar em branco.");
        }
        // Limite de tamanho (50 caracteres)
        if (cidade.length() > 50) {
            throw new IllegalArgumentException("A cidade não pode exceder 50 caracteres.");
        }

        this.cidade = cidade;
    }

    public String getRua() {return this.rua;}
    public Integer getNumero() {return this.numero;}
    public String getComplemento() {return this.complemento;}
    public String getBairro() {return this.bairro;}
    public String getCidade() {return this.cidade;}

    @Override
    public String toString() {
        return "Endereco{" +
                "rua='" + rua + '\'' +
                ", numero=" + numero +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                '}';
    }
}
