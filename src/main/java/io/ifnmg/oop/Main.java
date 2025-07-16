package io.ifnmg.oop;

import io.ifnmg.oop.endereco.Endereco;
import io.ifnmg.oop.endereco.EnderecoRepository;
import io.ifnmg.oop.pedido.*;

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

        System.out.println(e1.getId());
        System.out.println(p1.getId());
    }
}