package io.ifnmg.oop;

import io.ifnmg.oop.embrulho.*;
import io.ifnmg.oop.endereco.*;
import io.ifnmg.oop.pedido.*;
import java.math.BigDecimal;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        EnderecoRepository enderecoRepository = new EnderecoRepository();
        Endereco e1 = new Endereco("R. Santa Bernadete", 294, " ", "Todos os Santos", "Montes Claros");
        Endereco e2 = new Endereco("R. Santa Bernadete", 294, " ", "Todos os Santos", "Montes Claros");
        enderecoRepository.saveOrUpdate(e1);
        enderecoRepository.saveOrUpdate(e2);
        enderecoRepository.delete(e2);

        PedidoRepository pedidoRepository = new PedidoRepository();
        Pedido p1 = new Pedido();
        p1.setDataEntrega(LocalDate.of(2025, 7, 20));
        p1.setEntregue(false);
        p1.setRetirada(true);
        pedidoRepository.saveOrUpdate(p1);
        
        EmbrulhoRepository embrulhoRepository = new EmbrulhoRepository();
        Embrulho em1 = new Embrulho();
        em1.setNome("Verde com bolinhas");
        em1.setValorBase(BigDecimal.valueOf(10.5));
        em1.setEstoque(20);
        embrulhoRepository.saveOrUpdate(em1);

        System.out.println(e1.getId());
        System.out.println(p1.getId());
        System.out.println(em1.getId());
    }
}