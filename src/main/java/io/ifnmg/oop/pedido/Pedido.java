package io.ifnmg.oop.pedido;

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
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

@Entity
public class Pedido
        extends ProjectEntity
        implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private Boolean retirada;

    @Column(nullable = false)
    private LocalDate dataEntrega;

    @Column(nullable = false)
    private Boolean entregue;

    @Transient
    private BigDecimal valorPedido;

    public Boolean getEntregue() {
        return entregue;
    }

    public void setEntregue(Boolean entregue) {
        this.entregue = entregue;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        if (dataEntrega.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("A data de entrega não pode ser antes da data atual.");
        }

        this.dataEntrega = dataEntrega;
    }

    public Boolean getRetirada() {
        return retirada;
    }

    public void setRetirada(Boolean retirada) {
        this.retirada = retirada;
    }

    public BigDecimal getValorPedido() {
        return valorPedido;
    }

    @PostLoad
    private void calcularValorTotal(){
        valorPedido = BigDecimal.valueOf(1200);
    }
}

