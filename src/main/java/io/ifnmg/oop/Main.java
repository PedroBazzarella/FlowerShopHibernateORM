package io.ifnmg.oop;

import io.ifnmg.oop.embrulho.*;
import io.ifnmg.oop.endereco.*;
import io.ifnmg.oop.pedido.*;
import io.ifnmg.oop.cliente.*;
import java.math.BigDecimal;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        ClienteRepository clienteRepository = new ClienteRepository();
        Cliente c1 = new Cliente();
        c1.setNome("Carlos Multiplos");
        c1.setTelefone("999121212");
        clienteRepository.saveOrUpdate(c1);

        /*
            Teste de restauração, busca, criação e deleção de dado.
            Verifica se existe o cliente Mario VersaoUm no banco, caso exista, o modifique.
            Verifica se existe o cliente Mario VersaoDois no banco, caso exista, o apague.
         */
        Cliente c2 = clienteRepository.findByName("Mario VersaoUm");
        if(c2 == null){
            c2 = clienteRepository.findByName("Mario VersaoDois");
            if(c2 == null){
                c2 = new Cliente();
                c2.setNome("Mario VersaoUm");
                c2.setTelefone("999121212");
                clienteRepository.saveOrUpdate(c2);
            }else{
                clienteRepository.delete(c2);
            }
        }else{
            c2.setNome("Mario VersaoDois");
            clienteRepository.saveOrUpdate(c2);
        }

        /*
            Testes de persistência para os demais dados.
            Um dado mantido, outro apagado após o salvamento.
         */
        EnderecoRepository enderecoRepository = new EnderecoRepository();
        Endereco e1 = new Endereco("R. Incluida", "200", " ", "Bairro Classico", "Montes Claros");
        enderecoRepository.saveOrUpdate(e1);
        Endereco e2 = new Endereco("R. Nao Incluida", "404", " ", "Bairro Talqual", "Montes Claros");
        enderecoRepository.saveOrUpdate(e2);
        enderecoRepository.delete(e2);

        PedidoRepository pedidoRepository = new PedidoRepository();
        Pedido p1 = new Pedido();
        p1.setDataEntrega(LocalDate.now().plusDays(2));
        p1.setEntregue(false);
        p1.setRetirada(true);
        pedidoRepository.saveOrUpdate(p1);
        /*
            Esse pedido cria uma exceção, data antes da atual
         */
//        Pedido p2 = new Pedido();
//        p2.setDataEntrega(LocalDate.of(2001, 9, 11));
//        p2.setEntregue(false);
//        p2.setRetirada(true);
//        pedidoRepository.saveOrUpdate(p2);
        
        EmbrulhoRepository embrulhoRepository = new EmbrulhoRepository();
        Embrulho em1 = new Embrulho();
        em1.setNome("Verde com bolinhas");
        em1.setValorBase(BigDecimal.valueOf(10.5));
        em1.setEstoque(20);
        embrulhoRepository.saveOrUpdate(em1);
        Embrulho em2 = new Embrulho();
        em2.setNome("Azul com estrelinhas");
        em2.setValorBase(BigDecimal.valueOf(12.0));
        em2.setEstoque(20);
        embrulhoRepository.saveOrUpdate(em2);
        embrulhoRepository.delete(em2);

//        System.out.println(e1.getId());
//        System.out.println(p1.getId());
//        System.out.println(em1.getId());
    }
}