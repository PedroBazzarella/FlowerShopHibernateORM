/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.ifnmg.oop.funcionario;

import io.ifnmg.oop.repository.ProjectEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays;

/**
 *
 * @author Matheus Antunes <maf6@aluno.ifnmg.edu.br>
 */
@Entity
public class Funcionario
        extends ProjectEntity
        implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false)
    private Long cpf;

    @Column(nullable = false, length = 30)
    private String telefone;

    @Column(nullable = false)
    private BigDecimal salarioBase;

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.length() > 100) {
            throw new IllegalArgumentException("Nome deve ter ate 100 caracteres");
        }
        this.nome = nome;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        String cpfString = String.format("%011d", cpf);
        List<String> cpfsInvalidosConhecidos = Arrays.asList(
                "00000000000", "11111111111", "22222222222", "33333333333",
                "44444444444", "55555555555", "66666666666", "77777777777",
                "88888888888", "99999999999"
        );

        if (cpfsInvalidosConhecidos.contains(cpfString)) {
            throw new IllegalArgumentException("CPF invalido");
        }

        // Cálculo do primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            // Converte o caractere do dígito para inteiro e multiplica pelo peso
            soma += (cpfString.charAt(i) - '0') * (10 - i);
        }

        int resto = 11 - (soma % 11);
        char primeiroDigitoVerificador = (resto >= 10) ? '0' : (char) (resto + '0');

        // Valida o primeiro dígito
        if (primeiroDigitoVerificador != cpfString.charAt(9)) {
            throw new IllegalArgumentException("CPF invalido");
        }

        // Cálculo do segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += (cpfString.charAt(i) - '0') * (11 - i);
        }

        resto = 11 - (soma % 11);
        char segundoDigitoVerificador = (resto >= 10) ? '0' : (char) (resto + '0');

        // Valida o segundo dígito
        if (segundoDigitoVerificador != cpfString.charAt(10)) {
            throw new IllegalArgumentException("CPF invalido");
        } else {
            this.cpf = cpf;
        }
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        // Expressão regular para validar telefone brasileiro (com ou sem DDD, com ou sem espaços/hífens)
        String regex = "^(?:(?:\\+|00)?(55)?\\s?)?(?:\\([1-9]{2}\\)|[1-9]{2})[-.\\s]?9?\\d{4}[-.\\s]?\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(telefone);
        if (matcher.matches()) {
            this.telefone = telefone;
        } else {
            throw new IllegalArgumentException("Numero nao compativel");
        }
    }

    public BigDecimal getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(BigDecimal salarioBase) {
        this.salarioBase = salarioBase;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="hashCode/equals/toString">
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.nome);
        hash = 59 * hash + Objects.hashCode(this.cpf);
        hash = 59 * hash + Objects.hashCode(this.telefone);
        hash = 59 * hash + Objects.hashCode(this.salarioBase);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return hashCode() == obj.hashCode();
    }

    @Override
    public String toString() {
        return "Funcionario{" + "nome=" + nome + ", cpf=" + cpf + ", "
                + "telefone=" + telefone + ", salarioBase=" + salarioBase + '}';
    }
    //</editor-fold>
}
