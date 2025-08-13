package io.ifnmg.oop.cliente;

import io.ifnmg.oop.repository.ProjectEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import javax.swing.*;
import java.io.Serial;
import java.io.Serializable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
public class Cliente
        extends ProjectEntity
        implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = false, length = 30)
    private String telefone;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        // Não pode ser null
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome não pode estar em branco.");
        }
        // Limite de tamanho (50 caracteres)
        if (nome.length() > 50) {
            throw new IllegalArgumentException("O nome não pode exceder 50 caracteres.");
        }

        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        
        // Expressão regular para validar telefone brasileiro (com ou sem DDD, com ou sem espaços/hífens)
        String regex = "^(?:(?:\\+|00)?(55)?\\s?)?(?:\\([1-9]{2}\\)|[1-9]{2})[-.\\s]?9?\\d{4}[-.\\s]?\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(telefone);
        if(matcher.matches()){
            this.telefone = telefone;
        }
        else {
            throw new IllegalArgumentException("Telefone não compatível.");
        }
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}


